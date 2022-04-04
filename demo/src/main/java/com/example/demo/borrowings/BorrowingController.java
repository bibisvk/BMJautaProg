package com.example.demo.borrowings;

import com.example.demo.cars.CarService;
import com.example.demo.customers.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingController {
    private BorrowingService borrowingService;
    private CustomerService customerService ;
    private CarService carService;

    public  BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/api/borrowings/{borrowingId}")
    public BorrowingDto getBorrowing(@PathVariable int borrowingId){
        return borrowingService.getBorrowing(borrowingId);
    }

    @GetMapping("/api/borrowings")
    public List<BorrowingDto> getBorrowings(@RequestParam(required = false) Long borrowingId){
        return borrowingService.getBorrowings(borrowingId);
    }

    @PostMapping("/api/borrowings")
    public Long createBorrowing(@RequestBody BorrowingDto borrowingDto){
        return borrowingService.createBorrowing(borrowingDto);
    }

    @DeleteMapping("/api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        borrowingService.deleteBorrowing(borrowingId);
    }

    @PutMapping("/api/borrowings/{borrowingId}")
    public void updateBorrowing(@PathVariable int borrowingId, @RequestBody BorrowingDto borrowingDto) {
        borrowingService.updateBorrowing(borrowingId, borrowingDto);
    }
}
