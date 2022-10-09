package com.example.demo;


import com.example.demo.borrowing.cars.service.CarDto;
import com.example.demo.borrowing.cars.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MockitoExtension.class)

public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    // NOTE: @MockBean is a spring class. Not a Mockito class
    @MockBean
    private CarService carService;

   private static ObjectMapper mapper = new ObjectMapper();
   /*private static ObjectMapper mapper = JsonMapper.builder()
           .findAndAddModules()
           .build();
*/

    @Test
    @SneakyThrows
    public void createCar() {
        when(carService.createCar(any())).thenReturn(1);

        CarDto dto = new CarDto().setId(4)
                .setPrice("high")
                .setDoors(5)
                .setPersons(5)
                .setLug_boot("very much")
                .setSafety("on board")
                .setEKEndDate(LocalDate.parse("2023-05-12"))
                .setTKEndDate(LocalDate.parse("2023-05-12"))
                .setPZPEndDate(LocalDate.parse("2025-05-12"));
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(
                        post("/api/cars")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Matchers.equalTo(1)));

        verify(carService, times(1)).createCar(any());
    }
}
