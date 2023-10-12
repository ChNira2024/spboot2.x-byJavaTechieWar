package com.nt.niranjana.spboot2x.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nt.niranjana.spboot2x.entity.PassengerDetailsEntity;
import com.nt.niranjana.spboot2x.model.TicketInfo;

public interface TicketService 
{
	public TicketInfo registerPassengerInfo(PassengerDetailsEntity pinfo) throws JsonProcessingException;
	public List<PassengerDetailsEntity> fetchAllPassenger();

}
