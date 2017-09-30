package com.mayer.cart.beans;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private Map<String, ShoppingCartItem> items = new HashMap<String, ShoppingCartItem>();
	
	private String bookName;
	public void addToCart(String bookName, int price){
		this.bookName = bookName;
		if(items.containsKey(bookName)){
			ShoppingCartItem item = items.get(bookName);
			item.setNumber(item.getNumber() + 1);
			
		}else {
			ShoppingCartItem item = new ShoppingCartItem();
			item.setBookName(bookName);
			item.setNumber(1);
			item.setPrice(price);
			items.put(bookName, item);
		}
	}
	
	public String getBookName() {
		return bookName;
	}
	public int getTotalNumber(){
		int total = 0;
		for (ShoppingCartItem item : items.values()) {
			total += item.getNumber();
		}
		return total;
	}
	
	public int getTotalMoney(){
		int money = 0;
		for (ShoppingCartItem item : items.values()) {
			money += item.getNumber() * item.getPrice();
		}
		return money;
	}
}
