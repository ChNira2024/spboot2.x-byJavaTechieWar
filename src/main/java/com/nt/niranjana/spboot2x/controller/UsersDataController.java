package com.nt.niranjana.spboot2x.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.niranjana.spboot2x.entity.UsersData;
import com.nt.niranjana.spboot2x.security.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UsersDataController 
{
	private Logger logger = org.slf4j.LoggerFactory.getLogger(UsersDataController.class);
	@Autowired
	private UserService service;

	//To know the current user name
	@GetMapping(value="/currentuser",produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_admin",notes = "getCurrentUsersName from DB")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String getCurrentUserName(Principal principal)
	{
		logger.info("UsersDataController:getCurrentUserName() method{}",principal.getName());
		return "Current User Name is: "+principal.getName();
	}
	
	@PostMapping(value = "/createuser",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:role_admin",notes = "creating login UsersData and stored db")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<UsersData> createUser(@RequestBody UsersData userData)
	{
		logger.info("UsersDataController:createUser() method{}",userData);
		if(userData!=null)
		{
			UsersData createdUsers = service.createUser(userData);
			return ResponseEntity.ok(createdUsers);
		}
		else
		{
			logger.error("Problem to create user");
		}
		return null;
	}
	
	@GetMapping(value="/listOfData",produces = {"application/json","application/xml"})
	@ApiOperation(value="auth:roles_admin",notes = "fetch listOfusersData from DB")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<UsersData>> getListOfUsers()
	{
		logger.info("UsersDataController:getListOfUsers() method{}");
		List<UsersData> listOfUsers = service.getUser();
		logger.info("fetching listofUsers From Database{} :",listOfUsers);
		if(listOfUsers != null)
		{
			List<UsersData> allUsers = service.getUser();			
			return ResponseEntity.ok(allUsers);
		}
		else
		{
			logger.error("Problem to fetching listofUsers From Database{} :",listOfUsers);
			return ResponseEntity.noContent().build();
		}
	}
}
