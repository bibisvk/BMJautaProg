package com.example.demo.borrowings;

import com.example.demo.cars.CarDto;
import com.example.demo.customers.CustomerDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDate;
import java.util.Date;

public class BorrowingDto {
    private int borrowingId;
    private Long carId;
    private Long customerId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingEndDate;
    private String rodneCislo;
    //private CarDto carDto;
    //private CustomerDto customerDto;

    public String getRodneCislo() {
        return rodneCislo;
    }

    public void setRodneCislo(String rodneCislo) {
        this.rodneCislo = rodneCislo;
    }


    public int getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(int borrowingId) {
        this.borrowingId = borrowingId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getBorrowingStartDate() {
        return borrowingStartDate;
    }

    public void setBorrowingStartDate(LocalDate borrowingStartDate) {
        this.borrowingStartDate = borrowingStartDate;
    }

    public LocalDate getBorrowingEndDate() {
        return borrowingEndDate;
    }

    public void setBorrowingEndDate(LocalDate borrowingEndDate) {
        this.borrowingEndDate = borrowingEndDate;
    }


/*
    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }*/
}

