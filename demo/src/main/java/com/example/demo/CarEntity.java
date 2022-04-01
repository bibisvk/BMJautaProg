package com.example.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CarEntity {
    @Id
    @GeneratedValue
    private int id;

    private String price;
    private int doors;
    private int persons;
    private String lug_boot;
    private String safety;
    private Date EKEndDate;
    private Date TKEndDate;
    private Date PZPEndDate;

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

    public Date getEKEndDate() {
        return EKEndDate;
    }

    public void setEKEndDate(Date EKEndDate) {
        this.EKEndDate = EKEndDate;
    }

    public Date getTKEndDate() {
        return TKEndDate;
    }

    public void setTKEndDate(Date TKEndDate) {
        this.TKEndDate = TKEndDate;
    }

    public Date getPZPEndDate() {
        return PZPEndDate;
    }

    public void setPZPEndDate(Date PZPEndDate) {
        this.PZPEndDate = PZPEndDate;
    }
}
