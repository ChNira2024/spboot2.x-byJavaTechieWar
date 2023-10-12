package com.nt.niranjana.spboot2x.model;

import java.util.Arrays;

public class Product{
	
	private String[] items;
	
	private double[] price;
	
	private String[] emails;

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public double[] getPrice() {
		return price;
	}

	public void setPrice(double[] price) {
		this.price = price;
	}

	public String[] getEmails() {
		return emails;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Product [items=" + Arrays.toString(items) + ", price=" + Arrays.toString(price) + ", emails="
				+ Arrays.toString(emails) + "]";
	}

	

}
