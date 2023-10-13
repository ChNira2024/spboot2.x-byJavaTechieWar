package com.nt.niranjana.spboot2x.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.UsersData;
import com.nt.niranjana.spboot2x.repo.UsersDataRepo;
import com.nt.niranjana.spboot2x.role.Role;


@Service
public class UserService 
{
	@Autowired
	private UsersDataRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UsersData createUser(UsersData userData)
	{
		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		roles.addAll(userData.getRoles());
		System.out.println("userData: "+userData);
		userData.setId(UUID.randomUUID().toString());
		userData.setPassword(passwordEncoder.encode(userData.getPassword()));
		userData.setRoles(roles);
		return repo.save(userData);
	}
	
	public List<UsersData> getUser()
	{
		return repo.findAll();
	}

}
