package com.nt.niranjana.spboot2x.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.Employee;
import com.nt.niranjana.spboot2x.service.IInsertExcelDataToDatabaseService;
import com.nt.niranjana.spboot2x.util.CheckFileFormat;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/upload")
public class InsertExcelDataToDatabaseController 
{
	
	@Autowired
	private IInsertExcelDataToDatabaseService service;
	
	@PostMapping(value="/excelUpload",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="InsertExcelDataIntoDB",notes = "This endpoint helps to insert excel data into database")
	public ResponseEntity<?> InsertExcelDataIntoDB(@RequestParam("xlsFile") MultipartFile file)
	{					
		if(CheckFileFormat.checkExcelFormat(file))
		{
			service.insertExcelToDB(file);
			return ResponseEntity.ok(Map.of("message","Excel File data saved into Database successfully!!"));
		}
		else
		{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel file only");
		}
	}
	
	@GetMapping("/getAllEmployeesDetails")
	public List<Employee> getAllEmplyeeData()
	{
		return 	service.getAllEmplyeeData();
		
	}		
}
