package com.nt.niranjana.spboot2x.exception;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNotSavedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotSavedException() {
		super();
	}
	
	public EmployeeNotSavedException(String msg) {
		super(msg);
	}
	
}
