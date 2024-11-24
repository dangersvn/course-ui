package com.example.courses_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {UserDetailsServiceAutoConfiguration.class}) 
//Note: if we don't have this configuration, we have a warning UserDetailServiceAutoConfiguration 
//as Spring Security is still looking for a UserDetailsService bean
public class CoursesManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesManagementServiceApplication.class, args);
	}

}
