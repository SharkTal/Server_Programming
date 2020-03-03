package com.example.CustomerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CustomerList.domain.Customer;
import com.example.CustomerList.domain.CustomerDAOImpl;

@SpringBootApplication
public class CustomerListApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerListApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CustomerListApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(CustomerDAOImpl customerDAO) {
		return (args) -> {
			// Database is created by using resources/schema.sql
			
			// Insert some demo data
	        customerDAO.save(new Customer("Timo", "Lee"));
	        customerDAO.save(new Customer("Mikaella", "Tang"));
	        customerDAO.save(new Customer("Susan", "Laire"));
		};
	};
}
