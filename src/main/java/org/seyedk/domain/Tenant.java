package org.seyedk.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;

    String firstName;
    String lastName;
    String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BOOKING_ID")
    @JsonIgnore
    private RegistrationRecord bookingRecord;

    public Tenant() {
    }

    public Tenant(String firstName, String lastName, String gender,RegistrationRecord bookingRecord ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bookingRecord= bookingRecord;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public RegistrationRecord getBookingRecord() {
        return bookingRecord;
    }

    public void setBookingRecord(RegistrationRecord bookingRecord) {
        this.bookingRecord = bookingRecord;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender +"]";
    }

}
