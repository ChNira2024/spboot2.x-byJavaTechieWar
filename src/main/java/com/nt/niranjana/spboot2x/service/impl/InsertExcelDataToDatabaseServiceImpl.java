package com.nt.niranjana.spboot2x.service.impl;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.Employee;
import com.nt.niranjana.spboot2x.repo.IInsertExcelDataToDatabaseRepo;
import com.nt.niranjana.spboot2x.service.IInsertExcelDataToDatabaseService;
import com.nt.niranjana.spboot2x.util.CheckFileFormat;

@Service
public class InsertExcelDataToDatabaseServiceImpl implements IInsertExcelDataToDatabaseService{

	@Autowired
	private IInsertExcelDataToDatabaseRepo repo;
	String line;
	@Override
	public void insertExcelToDB(MultipartFile file)  
	{
		try 
		{
			List<Employee> empsData = CheckFileFormat.convertExcelDataToListOfEmployee(file.getInputStream());
			repo.saveAll(empsData);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Employee> getAllEmplyeeData()
	{
		return 	repo.findAll();
		
	}

}
