package com.example.demo.borrowing.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class BorrowingDto {
    private int borrowingId;
    private Long carId;
    private Long customerId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingEndDate;


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
}

