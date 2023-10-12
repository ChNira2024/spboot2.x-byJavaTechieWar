package com.nt.niranjana.spboot2x.model;

public class Product2{
	
	private String items;
	
	private double price;
	
	private String emails;

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Product2 [items=" + items + ", price=" + price + ", emails=" + emails + "]";
	}

	
}
