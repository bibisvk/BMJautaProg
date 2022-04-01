package com.example.demo;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private static CarDto mapToCarDto(CarEntity carEntity) {
        CarDto carDto = new CarDto();

        carDto.setId(carEntity.getId());
        carDto.setPrice(carEntity.getPrice());
        carDto.setDoors(carEntity.getDoors());
        carDto.setPersons(carEntity.getPersons());
        carDto.setLug_boot(carEntity.getLug_boot());
        carDto.setSafety(carEntity.getSafety());
        carDto.setEKEndDate(carEntity.getEKEndDate());
        carDto.setPZPEndDate(carEntity.getPZPEndDate());
        carDto.setTKEndDate(carEntity.getTKEndDate());

        return carDto;
    }

    @Transactional
    public List<CarDto> getCars(String carName) {
        List<CarDto> ret = new LinkedList<>();
        for (CarEntity c1 : carRepository.findAll()) {
            CarDto c2 = mapToCarDto(c1);
            ret.add(c2);
        }
        return ret;
    }

    @Transactional
    public int createCar(CarDto carDto) {
        CarEntity carEntity = new CarEntity();

        carEntity.setPrice(carDto.getPrice());
        carEntity.setDoors(carDto.getDoors());
        carEntity.setPersons(carDto.getPersons());
        carEntity.setLug_boot(carDto.getLug_boot());
        carEntity.setSafety(carDto.getSafety());
        carEntity.setEKEndDate(carDto.getEKEndDate());
        carEntity.setPZPEndDate(carDto.getPZPEndDate());
        carEntity.setTKEndDate(carDto.getTKEndDate());

        this.carRepository.save(carEntity);

        return carEntity.getId();
    }

    @Transactional
    public CarDto getCar(int carId) {
        Optional<CarEntity> byId = carRepository.findById(carId);
        if (byId.isPresent()) {
            return mapToCarDto(byId.get());
        }
        return null;
    }

    @Transactional
    public void deleteCar(int carId) {
        Optional<CarEntity> byId = carRepository.findById(carId);
        if (byId.isPresent()) {
            carRepository.delete(byId.get());
        }
    }

    @Transactional
    public void updateCar(int carId, CarDto carDto) {
        Optional<CarEntity> byId = carRepository.findById(carId);
        if (byId.isPresent()) {
            byId.get().setPrice(carDto.getPrice());
            byId.get().setSafety(carDto.getSafety());
            byId.get().setLug_boot(carDto.getLug_boot());
            byId.get().setPersons(carDto.getPersons());
            byId.get().setDoors(carDto.getDoors());
            byId.get().setEKEndDate(carDto.getEKEndDate());
            byId.get().setPZPEndDate(carDto.getPZPEndDate());
            byId.get().setTKEndDate(carDto.getTKEndDate());
        }
    }
}
