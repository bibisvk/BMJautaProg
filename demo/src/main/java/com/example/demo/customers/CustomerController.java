package com.example.demo.customers;

import com.example.demo.cars.CarEntity;
import com.example.demo.cars.CarPDFExport;
import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @GetMapping("/api/customers/pdf")
    public void generator(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerkey, headervalue);
        List<CustomerEntity> customerEntityList = customerService.getAllCustomers();
        CustomerPDFExport customerPDFExport = new CustomerPDFExport();
        customerPDFExport.setCustomerEntityList(customerEntityList);
        customerPDFExport.generate(response);
    }
}
