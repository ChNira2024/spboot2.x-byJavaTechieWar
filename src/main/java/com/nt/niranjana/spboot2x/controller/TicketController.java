//package com.nt.niranjana.spboot2x.controller;
//
//
//import java.util.List;
//
//import org.jsondoc.core.annotation.Api;
//import org.jsondoc.core.annotation.ApiMethod;
//import org.jsondoc.core.pojo.ApiVisibility;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.nt.niranjana.spboot2x.entity.PassengerDetailsEntity;
//import com.nt.niranjana.spboot2x.model.TicketInfo;
//import com.nt.niranjana.spboot2x.service.TicketService;
//
//import io.swagger.annotations.ApiOperation;
//
//
//@RestController
//@RequestMapping("/ticket")
//@Api(name="Ticket Management System",description="Passenger Information",group="Dev-Management",visibility = ApiVisibility.PUBLIC)
//public class TicketController 
//{
//	Logger log = LoggerFactory.getLogger(TicketController.class);
//	@Autowired
//	private TicketService ticketService;
//
//	@PostMapping(value = "/bookTickets",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
//	@ApiOperation(value="booking tickets")
//	@ApiMethod(description = "Booking ticket for passenger")
//	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerDetailsEntity passengerInfo) throws JsonProcessingException 
//	{
//		TicketInfo ticketInfo = ticketService.registerPassengerInfo(passengerInfo);
//		return new ResponseEntity<>(ticketInfo,HttpStatus.CREATED);
//	}
//
//	@GetMapping(value="/getAllPassengerDetails",produces = {"application/json","application/xml"})
//	@ApiOperation(value="fetch all tickets")
//	@ApiMethod(description = "Fetcing all the Passenger Details")
//	public List<PassengerDetailsEntity> getAllPassenger() 
//	{
//		return ticketService.fetchAllPassenger();
//	}
//	
//}