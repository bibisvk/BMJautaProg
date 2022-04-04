package com.example.demo.borrowings;

import com.example.demo.cars.CarEntity;
import com.example.demo.customers.CustomerEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private Long borrowingId;

    @JoinColumn(name = "customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity borrower;

    @JoinColumn(name = "carId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CarEntity borrowedCar;
    private int personalNumber;
    private int carNumber;
    private Date borrowingStartDate;
    private Date borrowingEndDate;
    private int customerId;
    private int carId;

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

    public void setBorrowingId(long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public Long getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Long borrowingId) {
        this.borrowingId = borrowingId;
    }
    public void setBorrower(CustomerEntity borrower){this.borrower = borrower;}
    public CustomerEntity getBorrower(){
        return borrower;
    }

    public void setBorrowedCar(CarEntity car){
        this.borrowedCar = car;
    }

    public CarEntity getBorrowedCar(){
        return borrowedCar;
    }
}
