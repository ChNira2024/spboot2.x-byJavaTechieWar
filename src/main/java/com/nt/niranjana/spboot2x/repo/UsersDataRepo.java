package com.nt.niranjana.spboot2x.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.spboot2x.entity.UsersData;



public interface UsersDataRepo extends JpaRepository<UsersData, String> 
{

	public Optional<UsersData>findUsersDataByUsersname(String name);
}
