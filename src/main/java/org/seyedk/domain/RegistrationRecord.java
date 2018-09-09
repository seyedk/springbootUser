package org.seyedk.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class RegistrationRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    private String assetNumber;
    private String origin;
    private String destination;
    private String movingDate;
    private Date registrationDate;
    private String price;
    private String status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="bookingRecord")
    Set<Tenant> tenants;

    public RegistrationRecord() {
    }

    public RegistrationRecord(String assetNumber, String from, String to,
                              String movingDate, Date registrationDate, String price) {
        this.assetNumber = assetNumber;
        this.origin = from;
        this.destination = to;
        this.movingDate = movingDate;
        this.registrationDate = registrationDate;
        this.price = price;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(String movingDate) {
        this.movingDate = movingDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Set<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(Set<Tenant> tenants) {
        this.tenants = tenants;
    }

    @Override
    public String toString() {
        return "RegistrationRecord [id=" + id + ", assetNumber=" + assetNumber + ", from=" + origin + ", to=" + destination
                + ", movingDate=" + movingDate + ", registrationDate=" + registrationDate + ", tenants=" + tenants
                + "]";
    }
}
