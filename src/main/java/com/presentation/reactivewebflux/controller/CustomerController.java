package com.presentation.reactivewebflux.controller;


import com.presentation.reactivewebflux.model.Customer;
//import com.presentation.reactivewebflux.service.CustomerService;
import com.presentation.reactivewebflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
     private CustomerService customerService;


    @GetMapping(produces="application/json")
    public Flux<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
//        return customerRepo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id);
      //  return customerRepo.findById(id);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
       // return customerRepo.save(customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") Long id) {
            customerService.deleteCustomer(id);
      //  customerRepo.deleteById(id);
    }

    @PutMapping(path="/{personId}", consumes="application/json")
    public Mono<Customer> updateCustomer(
            @PathVariable("personId") Long id,
            @RequestBody Customer customer) {
        return customerService.updateCustomer(id,customer);

//            customer.setCustomerId(id);
//           return customerRepo.save(customer);

    }
}
