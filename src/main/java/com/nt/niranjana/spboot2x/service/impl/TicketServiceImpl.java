package com.nt.niranjana.spboot2x.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.niranjana.spboot2x.entity.PassengerDetailsEntity;
import com.nt.niranjana.spboot2x.model.TicketInfo;
import com.nt.niranjana.spboot2x.repo.PassengerRepo;
import com.nt.niranjana.spboot2x.service.TicketService;
 

@Profile(value= {"projecteidiko","dev","prod"})
@Service
public class TicketServiceImpl implements TicketService 
{
	Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);
	@Autowired
	private PassengerRepo passengerRepo; 
	
	@Override
	public TicketInfo registerPassengerInfo(PassengerDetailsEntity pinfo) throws JsonProcessingException 
	{
		log.info(pinfo.toString());
		System.out.println(new ObjectMapper().writeValueAsString(pinfo));
		try {
			System.out.println("pinfo: "+pinfo);
            String passengerInfoDetails = new ObjectMapper().writeValueAsString(pinfo);
            log.info("TicketController: bookTicket() Tickets: {}", passengerInfoDetails);
            TicketInfo tinfo = new TicketInfo();
            tinfo.setFname(pinfo.getPfName());
            tinfo.setLname(pinfo.getPlname());
            tinfo.setFrom(pinfo.getpFrom());
            tinfo.setTo(pinfo.getpTo());
            tinfo.setJourneyDate(pinfo.getPjourneyDate());
            tinfo.setTicketPrice("5500.00");
            tinfo.setTicketStatus("CONFIRMD");
            passengerRepo.save(pinfo);
            return tinfo;
        } 
		catch (Exception e) 
		{
            log.error("TicketController: bookTicket() Error converting tickets to JSON", e);
        }
		return null;
	}

	@Override
	public List<PassengerDetailsEntity> fetchAllPassenger() 
	{
		try {
            log.info("TicketController: bookTicket() getAllPassenger: {}");
        } 
		catch (Exception e) 
		{
            log.error("TicketController: getAllPassenger() Error to getting Passenger details", e);
        }
		return passengerRepo.findAll();
	}

}
