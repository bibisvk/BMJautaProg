package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerController {
    public CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<CustomerDto> getCustomers(@RequestParam(required = false) String customerName){
        return customerService.getCustomers(customerName);
    }

    @PostMapping("/api/customers")
    public int createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/api/customers/{customerId}")
    public CustomerDto getCustomer(@PathVariable int customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }
}
