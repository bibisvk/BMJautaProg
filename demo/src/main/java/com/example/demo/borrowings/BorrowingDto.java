package com.example.demo.borrowings;

import com.example.demo.cars.CarDto;
import com.example.demo.customers.CustomerDto;

import java.util.Date;

public class BorrowingDto {
    private Long borrowingId;
    private Date borrowingStartDate;
    private Date borrowingEndDate;
    private CarDto carDto;

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    private CustomerDto customerDto;


    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }


    public Date getBorrowingStartDate() {
        return borrowingStartDate;
    }

    public void setBorrowingStartDate(Date borrowingStartDate) {
        this.borrowingStartDate = borrowingStartDate;
    }

    public Date getBorrowingEndDate() {
        return borrowingEndDate;
    }

    public void setBorrowingEndDate(Date borrowingEndDate) {
        this.borrowingEndDate = borrowingEndDate;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public void setCarDto(int id) {
    }
}

