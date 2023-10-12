package com.nt.niranjana.spboot2x.scheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.PassengerDetailsEntity;
import com.nt.niranjana.spboot2x.repo.PassengerRepo;
@Service
public class SchedulerServie 
{
	@Autowired
	private PassengerRepo repo;
	
	//@Scheduled(fixedRate = 15000)  //every 15 seconds this task executed
	@Scheduled(cron = "0 */5 * * * *") // Run every 5 minutes
	public void askHowru()
	{
		System.out.println(new Date().toString()+" How Are You ");
	}
	
	//@Scheduled(cron = "*/10 * * * * *") // Run every 10 seconds
	@Scheduled(cron = "0 */10 * * * *") // Run every 100 minutes
	public void fetchTotalTicketBookedDetails()
	{
		List<PassengerDetailsEntity> passengerDetails = repo.findAll();
		System.out.println(new Date().toString()+"passengerDetails{} "+passengerDetails);
		System.out.println("no.of ticket size{}:"+passengerDetails.size());
	}
}
