/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:13 PM. Last Modified 9/9/18 2:04 PM. Please use as is under your own discretion.
 */

package org.seyedk.component;

//simple price component!

public class Price {
	String assetNumber;
	String movingDate;
	String price;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Price [assetNumber=" + assetNumber + ", movingDate=" + movingDate + ", price=" + price + "]";
	}
	
}