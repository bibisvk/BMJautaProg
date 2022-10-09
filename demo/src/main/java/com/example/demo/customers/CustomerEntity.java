package com.example.demo.customers;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue
    private int customer_id;
    private String identification_number;
    private String customer_firstname;
    private String customer_lastname;
    private String o_number;


}