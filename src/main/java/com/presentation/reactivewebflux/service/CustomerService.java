package com.presentation.reactivewebflux.service;


import com.presentation.reactivewebflux.model.Customer;
import com.presentation.reactivewebflux.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public Flux<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    public Mono<Customer> getCustomerById(@PathVariable("id") Long id) {
        return customerRepo.findById(id);
    }

    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    public Mono<Customer> updateCustomer(
            @PathVariable("id") Long id,
            @RequestBody Customer customer) {
        customer.setCustomerId(id);
        return customerRepo.save(customer);
    }

    public void deleteCustomer(@PathVariable("id") Long id) {
        customerRepo.deleteById(id);
    }

}
