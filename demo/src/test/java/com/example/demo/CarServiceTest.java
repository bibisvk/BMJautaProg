package com.example.demo;

import com.example.demo.cars.dal.CarEntity;
import com.example.demo.cars.dal.CarRepository;
import com.example.demo.cars.service.CarDto;
import com.example.demo.cars.service.CarService;
import com.example.demo.exceptions.WrongNumberOfDoors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void setCarServiceSaveValid() throws WrongNumberOfDoors {
        int generatedId = 1;

        CarEntity fakeEntity = new CarEntity().setId(generatedId)
                .setPrice("medium")
                .setDoors(5)
                .setEKEndDate(LocalDate.parse("2022-06-06"))
                .setPersons(3)
                .setLug_boot("small")
                .setSafety("medium")
                .setPZPEndDate(LocalDate.parse("2022-06-06"))
                .setTKEndDate(LocalDate.parse("2022-06-06"));

        when(carRepository.save(any(CarEntity.class)))
                .thenReturn(fakeEntity);

        CarDto carToSave = new CarDto().setPrice("medium")
                .setDoors(5)
                .setEKEndDate(LocalDate.parse("2022-06-06"))
                .setPersons(3)
                .setLug_boot("small")
                .setSafety("medium")
                .setPZPEndDate(LocalDate.parse("2022-06-06"))
                .setTKEndDate(LocalDate.parse("2022-06-06"));

        int id = carService.createCar(carToSave);

        assertEquals(generatedId, id);
        verify(carRepository,times(1)).save(any());
    }
}
