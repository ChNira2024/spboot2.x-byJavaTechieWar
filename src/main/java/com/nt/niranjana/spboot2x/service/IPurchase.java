package com.nt.niranjana.spboot2x.service;

import java.util.List;

import com.nt.niranjana.spboot2x.model.Product;


public interface IPurchase {
	
	   
	   public  List<Product>  purchaseList(String []items, double[] prices,String[] emails)throws Exception;
	   
	   
	   public String purchageProduct(String items, double price, String emails)throws Exception ;
		

}
