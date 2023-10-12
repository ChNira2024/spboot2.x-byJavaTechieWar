package com.nt.niranjana.spboot2x.model;

import java.util.Arrays;

public class ProductList {
	
	private String[] items;
	private Double[] prices;
	private String[] emails;
	public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
	public Double[] getPrices() {
		return prices;
	}
	public void setPrices(Double[] prices) {
		this.prices = prices;
	}
	public String[] getEmails() {
		return emails;
	}
	public void setEmails(String[] emails) {
		this.emails = emails;
	}
	@Override
	public String toString() {
		return "ProductList [items=" + Arrays.toString(items) + ", prices=" + Arrays.toString(prices) + ", emails="
				+ Arrays.toString(emails) + "]";
	}
	
	
	
	

}
