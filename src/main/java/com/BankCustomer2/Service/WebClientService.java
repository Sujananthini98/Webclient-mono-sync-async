package com.BankCustomer2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.BankCustomer2.Entity.BankCustomer;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {

	private final WebClient webClient;

	@Autowired
	public WebClientService(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<BankCustomer> getCustomerByIdAsync(String id) {
		return webClient.get().uri("http://localhost:8080/bankCustomers/{id}", id).retrieve()
				.bodyToMono(BankCustomer.class);
	}

	public BankCustomer getCustomerByIdSync(String id) {
		return webClient.get().uri("http://localhost:8080/bankCustomers/{id}", id).retrieve()
				.bodyToMono(BankCustomer.class).block(); // Blocking call for synchronous operation
	}

	public Mono<BankCustomer> createCustomerAsync(BankCustomer customer) {
		return webClient.post().uri("http://localhost:8080/bankCustomers").bodyValue(customer).retrieve()
				.bodyToMono(BankCustomer.class);
	}

	public BankCustomer createCustomerSync(BankCustomer customer) {
		return webClient.post().uri("http://localhost:8080/bankCustomers").bodyValue(customer).retrieve()
				.bodyToMono(BankCustomer.class).block(); // Blocking call for synchronous operation
	}
}
