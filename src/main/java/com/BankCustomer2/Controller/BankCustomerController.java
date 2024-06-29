package com.BankCustomer2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BankCustomer2.Entity.BankCustomer;
import com.BankCustomer2.Service.BankCustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bankCustomers")
public class BankCustomerController {

    private final BankCustomerService service;

    @Autowired
    public BankCustomerController(BankCustomerService service) {
        this.service = service;
    }

    @GetMapping("/getThedata")
    @ResponseStatus(HttpStatus.OK)
    public Flux<BankCustomer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BankCustomer> getCustomerById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    @PostMapping("/postThedata")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BankCustomer> createCustomer(@RequestBody BankCustomer customer) {
        return service.createCustomer(customer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<BankCustomer> updateCustomer(@PathVariable String id, @RequestBody BankCustomer customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable String id) {
        return service.deleteCustomer(id);
    }
}