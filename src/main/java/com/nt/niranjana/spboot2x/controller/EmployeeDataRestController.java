package com.nt.niranjana.spboot2x.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.spboot2x.entity.EmployeeData;
import com.nt.niranjana.spboot2x.exception.EmployeeNotFetchedException;
import com.nt.niranjana.spboot2x.exception.EmployeeNotFoundException;
import com.nt.niranjana.spboot2x.exception.EmployeeNotSavedException;
import com.nt.niranjana.spboot2x.exception.EmployeeNotUpdatedException;
import com.nt.niranjana.spboot2x.service.IEmployeeDataService;

import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeDataRestController
{
	private static Logger logger =LoggerFactory.getLogger(EmployeeDataRestController.class);

	@Autowired
	private IEmployeeDataService empService;
	
	String employee = "Employee";
	
	@PostMapping(value="/save",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_admin",notes = "save employee data into DB")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeData empData)
	{
		logger.info("Inside EmployeeDataRestController:saveEmployee method");
		try 
		{
			Integer id = empService.saveEmployee(empData);
			logger.info("saveEmployee():saved employee ID: ",id);
			return new ResponseEntity<String>(employee+id+" Saved",HttpStatus.OK);
		}
		catch(EmployeeNotSavedException ense)
		{
			logger.error("employee data not saved",ense.getMessage());
			throw new EmployeeNotSavedException("saveEmployee():employee not saved: "+ense.getMessage());
			
		}
		
	}
	
	//Fetch All
	@GetMapping(value="/all",produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_staff",notes = "fetching all EmployeeData from DB")
	@PreAuthorize("hasRole('ROLE_STAFF')")
	public ResponseEntity<List<EmployeeData>> getAllEmployees()
	{
		logger.info("Inside EmployeeDataRestController:getAllEmployees method");
		try 
		{
			List<EmployeeData> listData= empService.getAllEmployees();
			logger.info("getAllEmployees():fetch list ofemployee : ",listData);
			return new ResponseEntity<List<EmployeeData>>(listData,HttpStatus.OK);
		}
		catch(EmployeeNotFetchedException enfe)
		{
			logger.error("employee data not fetched",enfe.getMessage());
			throw new EmployeeNotFetchedException("getAllEmployees():employee not fetched: "+enfe.getMessage());
			
		}
		
	}
	
	//Fetch one 
	@GetMapping(value="/one/{id}",produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_staff",notes = "fetching one EmployeeData by its ID from DB")
	@PreAuthorize("hasRole('ROLE_STAFF')")
	public ResponseEntity<EmployeeData> getOneEmployees(@PathVariable Integer id)
	{
		logger.info("Inside EmployeeDataRestController:getOneEmployees method");
		try 
		{
			EmployeeData empData= empService.getOneEmployee(id);
			logger.info("getOneEmployees():fetch employee by its id : ",empData);
			return new ResponseEntity<EmployeeData>(empData,HttpStatus.OK);
		}
		catch(EmployeeNotFoundException enfe)
		{
			logger.error("employee id not found",enfe.getMessage());
			throw new EmployeeNotFoundException("getOneEmployees():employee not fetched by its id: "+enfe.getMessage());
			
		}
	}
	
	//delete one
	@DeleteMapping(value="/remove/{id}",produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_admin",notes = "delete employee data by its ID from DB")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> deleteEmployees(@PathVariable Integer id)
	{
		logger.info("Inside EmployeeDataRestController:deleteEmployees method");
		try 
		{
			empService.deleteEmployee(id);
			logger.info("deleteEmployees():Delete employee by its id : ");
			return new ResponseEntity<String>(employee+id+" Deleted",HttpStatus.OK);			
		}
		catch(EmployeeNotFoundException enfe)
		{
			logger.error("employee id not found",enfe.getMessage());
			throw new EmployeeNotFoundException("deleteEmployees():problem to delete employee by its id: "+enfe.getMessage());			
		}			
	}
	
	//update employee data
	@PutMapping(value="/modify/{id}",produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_admin",notes = "update employee data by its ID into DB")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> updateEmployees(@PathVariable Integer id, @RequestBody EmployeeData emp)
	{
		logger.info("Inside EmployeeDataRestController:updateEmployees method");
		try
		{
			EmployeeData data = empService.getOneEmployee(id);
			data.setEmpName(emp.getEmpName());
			data.setEmpSal(emp.getEmpSal());
			data.setEmpDept(emp.getEmpDept());
			empService.saveEmployee(emp);
			logger.info("employee data updated successfully:");
			return new ResponseEntity<String>(employee+id+" Updated",HttpStatus.OK);
		}
		catch(EmployeeNotUpdatedException enue)
		{
			logger.error("problem to update employee data",enue.getMessage());
			throw new EmployeeNotUpdatedException("updateEmployees():problem to update employee by its id: "+enue.getMessage());		
		}
				
	}
}
