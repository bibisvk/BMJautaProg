package com.example.demo.borrowings;

import java.util.Date;

public class BorrowingDto {
    private Long borrowingId;
    private int personalNumber;
    private int carNumber;
    private Date borrowingStartDate;
    private Date borrowingEndDate;
    private int customerId;
    private int carId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
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
}
