package com.example.demo.customers;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CustomerDto {
    private int customer_id;
    private String identification_number;
    private String customer_firstname;
    private String customer_lastname;
    private String o_number;

}