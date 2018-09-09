/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:14 PM. Last Modified 9/7/18 10:37 AM. Please use as is under your own discretion.
 */

package org.seyedk.component;


import org.seyedk.domain.Inventory;
import org.seyedk.domain.RegistrationRecord;
import org.seyedk.domain.Tenant;
import org.seyedk.repo.InventoryRepository;
import org.seyedk.repo.RegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.xml.bind.PrintConversionEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@Component
public class Registration {
    private  static final Logger logger= LoggerFactory.getLogger(Registration.class);
    private  static final String PriceUrl = "itsABadURL";

    RegistrationRepository registrationRepository;
    InventoryRepository inventoryRepository;


    private WebClient webClient;

    Sender sender;

    @Autowired
    public Registration(RegistrationRepository registrationRepository,
        Sender sender,  InventoryRepository inventoryRepository){
        this.registrationRepository = registrationRepository;
        this.webClient = WebClient.create(PriceUrl);
        this.sender = sender;
        this.inventoryRepository = inventoryRepository;
    }

    public long Register(RegistrationRecord record){
        logger.info("Calling rices to get prices");

        validatePricesReactively(record);

        //check prices

        logger.info("calling inventory to get inventory ");

        //checking inventory


        Inventory inventory = inventoryRepository.findByAssetNumberAndMovingDate(record.getAssetNumber(), record.getMovingDate());

        if(!inventory.isAvailable(record.getTenants().size())){
            throw new RegistrationException("No more asset of this sort is available");
        }

        logger.info("scuccessfuly checked inventory " + inventory);
        logger.info("calling inventory to update iventory");

        //update inventory
        inventory.setAvailable(inventory.getAvailable() - record.getTenants().size());
        inventoryRepository.saveAndFlush(inventory);
        logger.info("sucessfully updated inventory");


        //saving registration

        record.setStatus(RegistrationStatus.REGISTRATION_CONFIRMED);
        Set<Tenant> tenants = record.getTenants();

        tenants.forEach(tenant -> tenant.setBookingRecord(record));
        record.setRegistrationDate(new Date());
        long id = registrationRepository.save(record).getId();

        logger.info("scuccessfully saved registration");

        ///send a message to search to update inventory

        logger.info("sending a registration event");

        Map<String, Object> registrationDetail = new HashMap<>();

        registrationDetail.put("ASSET_NUMBER", record.getAssetNumber());
        registrationDetail.put("MOVING_DATE", record.getMovingDate());
        registrationDetail.put("NEW_INVENTORY", inventory.getBookableInventory());

        sender.send(registrationDetail);

        logger.info("Booking event succcessully delivered " + registrationDetail);

        return id;

    }

    private void validatePricesReactively(RegistrationRecord record) {

//        Mono<Price> result =  webClient.get()
//                .uri("")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .flatMap(clientResponse -> clientResponse.bodyToMono(Price.class));
//
//        result.subscribe(price -> checkPrice(record.getPrice(),price.getPrice()));
    }


    public RegistrationRecord getRegistration(long id){
        return registrationRepository.findById(id).get();
    }

    public void updateStatus(String status, long regId){
        RegistrationRecord record = registrationRepository.findById(regId).get();

    }

    private void checkPrice(String requestedPrice, String actualPrice){
        logger.info("calling Price to get price (reactively collected) "+ actualPrice);
        if (!requestedPrice.equals(actualPrice))
            throw new RegistrationException("price is tampered");
    }



}
