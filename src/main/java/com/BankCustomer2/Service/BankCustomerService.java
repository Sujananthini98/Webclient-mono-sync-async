package com.BankCustomer2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankCustomer2.Entity.BankCustomer;
import com.BankCustomer2.Repository.BankCustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankCustomerService {

    private final BankCustomerRepository repository;

    @Autowired
    public BankCustomerService(BankCustomerRepository repository) {
        this.repository = repository;
    }

    public Flux<BankCustomer> getAllCustomers() {
        return repository.findAll();
    }

    public Mono<BankCustomer> getCustomerById(String id) {
        return repository.findById(id);
    }

    public Mono<BankCustomer> createCustomer(BankCustomer customer) {
        return repository.save(customer);
    }

    public Mono<BankCustomer> updateCustomer(String id, BankCustomer customer) {
        return repository.findById(id)
                .flatMap(existingCustomer -> {
                    existingCustomer.setName(customer.getName());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setBalance(customer.getBalance());
                    return repository.save(existingCustomer);
                });
    }

    public Mono<Void> deleteCustomer(String id) {
        return repository.deleteById(id);
    }
}