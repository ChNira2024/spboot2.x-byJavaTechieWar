package com.nt.niranjana.spboot2x.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.UsersData;
import com.nt.niranjana.spboot2x.repo.UsersDataRepo;

@Service
public class CustomUsersDetailsService implements UserDetailsService 
{

	@Autowired
	private UsersDataRepo userREpo;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException 
	{
		//loading user from database by username	
		UsersData user = userREpo.findUsersDataByUsersname(name).orElseThrow(()->new RuntimeException("User Not Found !!"));
		if(user == null)
		{
			throw new UsernameNotFoundException(name); 
		}
		return user;
	}

}
