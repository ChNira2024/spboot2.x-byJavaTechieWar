package com.nt.niranjana.spboot2x.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nt.niranjana.spboot2x.security.CustomUsersDetailsService;
import com.nt.niranjana.spboot2x.security.JwtAuthenticationEntryPoint;
import com.nt.niranjana.spboot2x.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebMvc
public class JwtAuthenticationSecurityConfig extends WebSecurityConfigurerAdapter
{
	public static final String[] PUBLIC_URLS = {"/auth/login","/v2/api-docs","/swagger-resources/**", "/webjars/**","/swagger-ui/**"}; 
	@Autowired
	private CustomUsersDetailsService customUsersDetailsService;
	
	@Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		 http.csrf().disable()
	        .authorizeHttpRequests()
	        .antMatchers(PUBLIC_URLS).permitAll()
	                .anyRequest()
	                .authenticated().and()
	                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(customUsersDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()  //This method is mandatory. Without this method error came:There is no PasswordEncoder mapped for the id "null"
	{                                                                                                          //because SpringBoot takes password as Encode format
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception 
	{
		return super.authenticationManagerBean();
	}

}

