package com.example.demo.borrowing.cars.test;

import com.example.demo.borrowing.cars.dal.CarEntity;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;

public class CarTest {

    @Test
    public void shouldCreateCar(){
        CarEntity car1 = new CarEntity();
        car1.setDoors(2);
        car1.setPersons(2);
        car1.setLug_boot("small");
        car1.setPrice("low");
        car1.setSafety("med");
        car1.setEKEndDate(LocalDate.parse("2004-10-02"));
        car1.setTKEndDate(LocalDate.parse("2004-10-02"));
        car1.setPZPEndDate(LocalDate.parse("2004-10-02"));
        Assert.assertNotNull(car1);
    }

    @Test
    public void CarShouldNotHaveMoreThan5Doors(){
        CarEntity car1 = new CarEntity();
        car1.setDoors(10);
        car1.setPersons(2);
        car1.setLug_boot("small");
        car1.setPrice("low");
        car1.setSafety("med");
        car1.setEKEndDate(LocalDate.parse("2004-10-02"));
        car1.setTKEndDate(LocalDate.parse("2004-10-02"));
        car1.setPZPEndDate(LocalDate.parse("2004-10-02"));
        Assert.assertFalse(car1.getDoors()<5);
    }

}
