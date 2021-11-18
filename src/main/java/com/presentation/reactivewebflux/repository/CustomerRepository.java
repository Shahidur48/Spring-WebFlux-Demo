package com.presentation.reactivewebflux.repository;

import com.presentation.reactivewebflux.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}
