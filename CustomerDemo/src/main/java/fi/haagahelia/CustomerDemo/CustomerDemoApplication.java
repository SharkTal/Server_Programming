package fi.haagahelia.CustomerDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.CustomerDemo.domain.Customer;
import fi.haagahelia.CustomerDemo.domain.CustomerDAOImpl;

@SpringBootApplication
public class CustomerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerDAOImpl customerDAO) {
		return(args) -> {
			customerDAO.save(new Customer("Timo", "Bitch"));
		};
	}
}
