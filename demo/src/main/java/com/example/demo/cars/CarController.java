package com.example.demo.cars;

import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<CarCheckDto> checkCars(@RequestParam(required = false) String carInfo){
        return carService.checkCars(carInfo);
    }
    @GetMapping("/api/cars/pdf")
    public void generator(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerkey, headervalue);
        List<CarEntity> carEntityList = carService.getAllCars();
        CarPDFExport carPDFExport = new CarPDFExport();
        carPDFExport.setCarEntityList(carEntityList);
        carPDFExport.generate(response);
    }
}
