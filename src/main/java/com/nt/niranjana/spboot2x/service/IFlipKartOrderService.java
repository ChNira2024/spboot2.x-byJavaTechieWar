package com.nt.niranjana.spboot2x.service;

public interface IFlipKartOrderService {
	
	public String orderService(String[] items,Double[] prices,String[] emails)throws Exception;

}
