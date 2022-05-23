package com.example.demo.borrowing.dal;

import com.example.demo.cars.dal.CarEntity;
import com.example.demo.customers.CustomerEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private int borrowingId;

    @JoinColumn(name = "customerId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity borrower;

    @JoinColumn(name = "carId")
    @ManyToOne(fetch = FetchType.LAZY)
    private CarEntity borrowedCar;

    private LocalDate borrowingStartDate;
    private LocalDate borrowingEndDate;


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

    public int getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(int borrowingId) {
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