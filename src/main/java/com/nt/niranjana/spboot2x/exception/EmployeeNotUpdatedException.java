package com.nt.niranjana.spboot2x.exception;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNotUpdatedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotUpdatedException() {
		super();
	}
	
	public EmployeeNotUpdatedException(String msg) {
		super(msg);
	}
	
}
