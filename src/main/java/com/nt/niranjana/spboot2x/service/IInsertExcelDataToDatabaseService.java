package com.nt.niranjana.spboot2x.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.Employee;

public interface IInsertExcelDataToDatabaseService 
{
	void insertExcelToDB(MultipartFile file);
	
	 List<Employee> getAllEmplyeeData();
	

}
