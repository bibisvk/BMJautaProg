package com.example.demo.borrowing.cars.dal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Accessors(chain = true)
public class CarEntity {
    @Id
    @GeneratedValue
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


}
