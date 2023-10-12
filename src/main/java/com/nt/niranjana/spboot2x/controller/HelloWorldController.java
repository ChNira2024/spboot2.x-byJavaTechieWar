package com.nt.niranjana.spboot2x.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@Tag(name="Hello World")
public class HelloWorldController 
{

	@GetMapping(value="/hello",produces = {"application/json","application/xml"})
	//@PostMapping(value = "/bookTickets",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="wishing hello",notes = "just say hello")
	public String helloWish() 
	{
		return "Hi Welcome to Swagger API Documentation";
	}
}
