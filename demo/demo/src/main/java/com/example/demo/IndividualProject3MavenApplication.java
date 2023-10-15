package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableCaching
public class IndividualProject3MavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndividualProject3MavenApplication.class, args);
	}

}
