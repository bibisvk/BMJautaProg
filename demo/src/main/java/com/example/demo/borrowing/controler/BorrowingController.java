package com.example.demo.borrowing.controler;

import com.example.demo.borrowing.service.BorrowingDto;
import com.example.demo.borrowing.dal.BorrowingEntity;
import com.example.demo.borrowing.service.BorrowingPDFExport;
import com.example.demo.borrowing.service.BorrowingService;
import com.example.demo.cars.CarService;
import com.example.demo.customers.CustomerService;
import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class  BorrowingController {
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
    public int createBorrowing(@RequestBody BorrowingDto borrowingDto){
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
    @GetMapping("/api/borrowings/pdf")
    public void generator(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_"+currentDateTime+".pdf";
        response.setHeader(headerkey, headervalue);
        List<BorrowingEntity> borrowingEntityList = borrowingService.getAllBorrowings();
        BorrowingPDFExport borrowingPDFExport = new BorrowingPDFExport();
        borrowingPDFExport.setBorrowingEntityList(borrowingEntityList);
        borrowingPDFExport.generate(response);
    }
}
