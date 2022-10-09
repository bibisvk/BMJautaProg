package com.example.demo;

import com.example.demo.borrowing.cars.dal.CarEntity;
import com.example.demo.borrowing.cars.service.CarDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class carMapper {
    public CarEntity toEntity(CarDto dto) {
        return new CarEntity()
                .setId(dto.getId())
                .setPrice(dto.getPrice())
                .setDoors(dto.getDoors())
                .setEKEndDate(dto.getEKEndDate())
                .setPersons(dto.getPersons())
                .setLug_boot(dto.getLug_boot())
                .setSafety(dto.getSafety())
                .setPZPEndDate(dto.getPZPEndDate())
                .setTKEndDate(dto.getTKEndDate());
    }

    public CarDto toDto(CarEntity entity) {
        return new CarDto()
                .setId(entity.getId())
                .setPrice(entity.getPrice())
                .setDoors(entity.getDoors())
                .setEKEndDate(entity.getEKEndDate())
                .setPersons(entity.getPersons())
                .setLug_boot(entity.getLug_boot())
                .setSafety(entity.getSafety())
                .setPZPEndDate(entity.getPZPEndDate())
                .setTKEndDate(entity.getTKEndDate());
    }
}
