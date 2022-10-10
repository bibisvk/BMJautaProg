package com.example.demo;

import com.example.demo.customers.CustomerDto;
import com.example.demo.customers.CustomerRepository;
import com.example.demo.customers.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceSaveFail {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void customerServiceFail() {
        // --- execution
        CustomerDto customerToSave = new CustomerDto().setCustomer_id(1)
                .setIdentification_number("22554")
                .setCustomer_firstname("Peter")
                .setCustomer_lastname("f")
                .setO_number("321123321");


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customerService.createCustomer(customerToSave));
        assertEquals("Something went wrong", exception.getMessage());

        verify(customerRepository, times(0)).save(any());
    }
}
