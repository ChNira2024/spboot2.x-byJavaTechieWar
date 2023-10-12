package com.nt.niranjana.spboot2x.exception;

import org.springframework.stereotype.Component;

@Component
public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(String msg) {
		super(msg);
	}
	
}
