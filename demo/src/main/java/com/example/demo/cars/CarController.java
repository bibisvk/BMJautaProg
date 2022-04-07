package com.example.demo.cars;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CarController {
    public CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public List<CarDto> getCars(@RequestParam(required = false) String carName){
        return carService.getCars(carName);
    }

    @PostMapping("/api/cars")
    public int createCar(@RequestBody CarDto carDto){
        return carService.createCar(carDto);
    }

    @GetMapping("/api/cars/{carId}")
    public CarDto getCar(@PathVariable int carId){
        return carService.getCar(carId);
    }

    @DeleteMapping("/api/cars/{carId}")
    public void deleteCar(@PathVariable Integer carId){
        carService.deleteCar(carId);
    }

    @PutMapping("/api/cars/{carId}")
    public void updateCar(@PathVariable Integer carId, @RequestBody CarDto carDto){
        carService.updateCar(carId, carDto);
    }
    @GetMapping("/api/cars/check")
    public List<CarCheck> checkCars(@RequestParam(required = false) String carInfo){
        return carService.checkCars(carInfo);
    }
}
