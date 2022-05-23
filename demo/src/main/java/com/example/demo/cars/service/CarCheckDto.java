package com.example.demo.cars.service;

import java.time.LocalDate;
import java.util.Date;

public class CarCheckDto {
    private int id;
    private LocalDate EKEndDate;
    private LocalDate TKEndDate;
    private LocalDate PZPEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
