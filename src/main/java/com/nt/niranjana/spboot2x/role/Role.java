package com.nt.niranjana.spboot2x.role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@Entity
public class Role 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleID;
	
	private String userRoleName;
}
