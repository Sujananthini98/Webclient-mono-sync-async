package com.BankCustomer2.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.BankCustomer2.Entity.BankCustomer;

public interface BankCustomerRepository extends ReactiveMongoRepository<BankCustomer, String> {
}