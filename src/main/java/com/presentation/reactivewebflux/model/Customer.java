package com.presentation.reactivewebflux.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Table
@Data
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customerId", nullable = false)
    private Long customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
    }


}
