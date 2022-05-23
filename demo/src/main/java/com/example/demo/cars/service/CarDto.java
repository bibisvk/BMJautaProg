package com.example.demo.cars.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class CarDto {
    private int id;
    private String price;
    private int doors;
    private int persons;
    private String lug_boot;
    private String safety;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate EKEndDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate TKEndDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate PZPEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getLug_boot() {
        return lug_boot;
    }

    public void setLug_boot(String lug_boot) {
        this.lug_boot = lug_boot;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public LocalDate getEKEndDate() {
        return EKEndDate;
    }

    public void setEKEndDate(LocalDate EKEndDate) {
        this.EKEndDate = EKEndDate;
    }

    public LocalDate getTKEndDate() {
        return TKEndDate;
    }

    public void setTKEndDate(LocalDate TKEndDate) {
        this.TKEndDate = TKEndDate;
    }

    public LocalDate getPZPEndDate() {
        return PZPEndDate;
    }

    public void setPZPEndDate(LocalDate PZPEndDate) {
        this.PZPEndDate = PZPEndDate;
    }
}
