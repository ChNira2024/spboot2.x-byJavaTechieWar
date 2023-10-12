package com.nt.niranjana.spboot2x.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.spboot2x.entity.PassengerDetailsEntity;


public interface PassengerRepo extends JpaRepository<PassengerDetailsEntity, Integer>{
	
	//fetch all passenger_details_entity data by using ID using "named param"
	//@Query("SELECT pid,pfName,plname,pFrom,pTo,pjourneyDate FROM  PassengerDetailsEntity  WHERE pfName=:name")
	//public List<PassengerDetailsEntity> fetchAllByName(String name); //Here named param(:no) and method param(no) both are must same...otherwise IllegalStateException

}