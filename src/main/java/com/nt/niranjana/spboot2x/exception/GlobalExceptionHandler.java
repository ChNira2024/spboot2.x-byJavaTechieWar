package com.nt.niranjana.spboot2x.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.niranjana.spboot2x.model.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse> exceptionHandler(BadCredentialsException ex) 
    {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false,HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
