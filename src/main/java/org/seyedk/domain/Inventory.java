/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:14 PM. Last Modified 9/8/18 8:33 AM. Please use as is under your own discretion.
 */

package org.seyedk.domain;


import javax.persistence.*;

@Entity

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String assetNumber;
    String movingDate;
    int available;


    public Inventory(){}

    public Inventory(String assetNumber, String movingDate, int available) {
        this.assetNumber = assetNumber;
        this.movingDate = movingDate;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(String movingDate) {
        this.movingDate = movingDate;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", assetNumber='" + assetNumber + '\'' +
                ", movingDate='" + movingDate + '\'' +
                ", available=" + available +
                '}';
    }

    //Custom parts
    public int getBookableInventory(){
        return available -5;
    }

    public boolean isAvailable(int count) { return (available-count)>5;}

}
