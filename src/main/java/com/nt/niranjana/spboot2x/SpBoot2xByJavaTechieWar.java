package com.nt.niranjana.spboot2x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class SpBoot2xByJavaTechieWar {

	public static void main(String[] args) {
		SpringApplication.run(SpBoot2xByJavaTechieWar.class, args);
		System.out.println("Swagger Application Started Successfully...");
	}
	
	@Bean
	public JavaMailSender javaMailSender()
	{
		return new JavaMailSenderImpl();
	}

}
