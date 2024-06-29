package com.BankCustomer2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.BankCustomer2.Entity.BankCustomer;
import com.BankCustomer2.Repository.BankCustomerRepository;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.BankCustomer2.Repository")
public class BankCustomer2Application {

	public static void main(String[] args) {
		SpringApplication.run(BankCustomer2Application.class, args);
	}

	@Bean
	CommandLineRunner init(BankCustomerRepository repository) {
		return args -> {
			// Delete all existing records
			repository.deleteAll().subscribe();

			// Insert a sample record
			BankCustomer customer = new BankCustomer();
			customer.setName("John Doe");
			customer.setEmail("john.doe@example.com");
			customer.setBalance(1000.0);

			repository.save(customer).subscribe();
		};
	}
}