package com.example.demo.customers;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private static CustomerDto mapToCustomerDto(CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomer_id(customerEntity.getCustomer_id());
        customerDto.setIdentification_number(customerEntity.getIdentification_number());
        customerDto.setCustomer_firstname(customerEntity.getCustomer_firstname());
        customerDto.setCustomer_lastname(customerEntity.getCustomer_lastname());
        customerDto.setO_number(customerEntity.getO_number());

        return customerDto;
    }

    @Transactional
    public List<CustomerDto> getCustomers(String customerName) {
        List<CustomerDto> ret = new LinkedList<>();
        for (CustomerEntity c1 : customerRepository.findAll()) {
            CustomerDto c2 = mapToCustomerDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public int createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setIdentification_number(customerDto.getIdentification_number());
        customerEntity.setCustomer_firstname(customerDto.getCustomer_firstname());
        customerEntity.setCustomer_lastname(customerDto.getCustomer_lastname());
        customerEntity.setO_number(customerDto.getO_number());

        this.customerRepository.save(customerEntity);

        return customerEntity.getCustomer_id();
    }

    @Transactional
    public CustomerDto getCustomer(int customerId) {
        Optional<CustomerEntity> byId = customerRepository.findById(customerId);
        if (byId.isPresent()) {
            return mapToCustomerDto(byId.get());
        }
        return null;
    }

    @Transactional
    public void deleteCustomer(int customerId) {
        Optional<CustomerEntity> byId = customerRepository.findById(customerId);
        if (byId.isPresent()) {
            customerRepository.delete(byId.get());
        }
    }

    @Transactional
    public void updateCustomer(int customerId, CustomerDto customerDto) {
        Optional<CustomerEntity> byId = customerRepository.findById(customerId);
        if (byId.isPresent()) {

            byId.get().setIdentification_number(customerDto.getIdentification_number());
            byId.get().setCustomer_firstname(customerDto.getCustomer_firstname());
            byId.get().setCustomer_lastname(customerDto.getCustomer_lastname());
            byId.get().setO_number(customerDto.getO_number());
        }
    }
}