package com.example.demo.customers.test;

import com.example.demo.customers.CustomerEntity;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void ShouldCreateCustomer(){
        CustomerEntity c1 = new CustomerEntity();
        c1.setCustomer_firstname("Jozko");
        c1.setCustomer_lastname("Mrkvicka");
        c1.setIdentification_number("872387932");
        c1.setO_number("EA768683");
        Assert.assertNotNull(c1);
    }
}
