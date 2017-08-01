package com.mayer.spring.beans;

public class Car {
	private String brand;
	private String corp;
	private double price;
	private int maxspeed;
	public Car(String brand, String corp, double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	
	
	public Car(String brand, String corp, int maxspeed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.maxspeed = maxspeed;
	}
	
	public Car(){
		
	}
	
	


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCorp() {
		return corp;
	}


	public void setCorp(String corp) {
		this.corp = corp;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getMaxspeed() {
		return maxspeed;
	}


	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}


	@Override
	public String toString() {
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxspeed=" + maxspeed + "]";
	}
	
}
