package com.nt.niranjana.spboot2x.exception;

public class BadCredentialsException extends RuntimeException
{

	public BadCredentialsException()
	{
		super();
	}
	
	public BadCredentialsException(String message)
	{
		super(message);
	}
}
