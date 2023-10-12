package com.nt.niranjana.spboot2x.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nt.niranjana.spboot2x.role.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 
 <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="user_table")
public class UsersData implements UserDetails
{

	@Id	
	//If you want String to be database key you need to use UUID to automatically generate key(use two below annotation,it is working for creating user and fetching user)
	@GeneratedValue(generator="system-uuid")   
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
//	@Column(name="user_name",nullable = false,length = 100)
	private String usersname;
	
	private String email;
	private String password;
	private String about;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="userdata_role",
	joinColumns = @JoinColumn(name="userid",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="roleid",referencedColumnName = "userRoleID"))
	private Set<Role> roles= new HashSet<>();

	//fetch data role based using getAuthorities method
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		List<SimpleGrantedAuthority> authorities = this. roles.stream().map((role)->new SimpleGrantedAuthority(role.getUserRoleName())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getUsername() 
	{
		return this.usersname;
	}
	@Override
	public String getPassword() 
	{
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return true;
	}
}
