package com.nt.niranjana.spboot2x.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

/*
 <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException 
	{

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
		
		// Authorization
		String requestHeader = request.getHeader("Authorization");
		
		// Bearer 2352345235sdfrsfgsdfsdf
		logger.info(" Header :  {}", requestHeader);
		
		String username = null;
		String token = null;
		
		//Header Section
		if (requestHeader != null && requestHeader.startsWith("Bearer")) 
		{
			// looking good
			token = requestHeader.substring(7);
			try 
			{
				username = this.jwtHelper.getUsernameFromToken(token);
			} 
			catch (IllegalArgumentException e) 
			{
				logger.info("Illegal Argument while fetching the username !!");
				e.printStackTrace();
			} 
			catch (ExpiredJwtException e) 
			{
				logger.info("Given jwt token is expired !!");
				e.printStackTrace();
			} 
			catch (MalformedJwtException e) 
			{
				logger.info("Some changed has done in token !! Invalid Token");
				e.printStackTrace();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}//Header section end 
		else 
		{
			logger.info("Invalid Header Value,Missing Bearer !! ");
		}

		//Token section
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) 
		{
			// fetch user detail from username
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			//once we get the token,validate the token
			Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
			if (validateToken) 
			{
				// set the authentication
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} 
			else 
			{
				logger.info("InValid Jwt token !!");
			}
		}//Token section end
		filterChain.doFilter(request, response);
	}
}