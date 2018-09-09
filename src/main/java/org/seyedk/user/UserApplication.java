/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:15 PM. Last Modified 9/8/18 8:44 AM. Please use as is under your own discretion.
 */

package org.seyedk.user;

import org.seyedk.component.Registration;
import org.seyedk.domain.Inventory;
import org.seyedk.domain.RegistrationRecord;
import org.seyedk.domain.Tenant;
import org.seyedk.repo.InventoryRepository;
import org.seyedk.repo.RegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
@ComponentScan(basePackages = "org.seyedk")
@EnableJpaRepositories(basePackages = "org.seyedk.repo")
@EntityScan(basePackages = "org.seyedk.domain")
@EnableJpaAuditing
public class UserApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);
	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private Registration registration;

	@Autowired
	InventoryRepository inventoryRepository;


	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}



	@Override
	public void run(String ... strings) throws Exception {
		Inventory[] invs = {
				new Inventory("BF100", "22-JAN-18", 100),
				new Inventory("BF101", "22-JAN-18", 100),
				new Inventory("BF102", "22-JAN-18", 100),
				new Inventory("BF103", "22-JAN-18", 100),
				new Inventory("BF104", "22-JAN-18", 100),
				new Inventory("BF105", "22-JAN-18", 100),
				new Inventory("BF106", "22-JAN-18", 100)};
		if(inventoryRepository.count()>0 ){

		}else {
			Arrays.asList(invs).forEach(inventory -> inventoryRepository.save(inventory));
		}

		RegistrationRecord registrationRecord = new RegistrationRecord("BF101", "NYC","SFO","22-JAN-18",new Date(),"101");
		Set<Tenant> tenants = new HashSet<Tenant>();
		tenants.add(new Tenant("Gean","Franc","Male", registrationRecord));
		//	tenants.add(new Passenger("Redi","Ivan","Female",registrationRecord));

		registrationRecord.setTenants(tenants);
		long record  = registration.Register(registrationRecord);
		logger.info("Regisration successfully saved..." + record);

		logger.info("Looking to load registrationRecord record...");
		logger.info("Result: " + registration.getRegistration(record));
	}
}
