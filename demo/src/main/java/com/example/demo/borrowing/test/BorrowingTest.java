package com.example.demo.borrowing.test;

import com.example.demo.borrowing.dal.BorrowingEntity;
import com.example.demo.borrowing.dal.BorrowingRepository;
import com.example.demo.cars.dal.CarEntity;
import com.example.demo.cars.dal.CarRepository;
import com.example.demo.customers.CustomerEntity;
import com.example.demo.customers.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class BorrowingTest {

    @Test
    public void ShouldCreateBorrowing(){
        BorrowingEntity borrowing1 = new BorrowingEntity();
        CustomerEntity c1 = new CustomerEntity();
        CarEntity car1 = new CarEntity();
        borrowing1.setBorrower(c1);
        borrowing1.setBorrowedCar(car1);
        borrowing1.setBorrowingStartDate(LocalDate.parse("2022-10-13"));
        borrowing1.setBorrowingEndDate(LocalDate.parse("2022-10-20"));
        Assert.assertNotNull(borrowing1);
    }
}
