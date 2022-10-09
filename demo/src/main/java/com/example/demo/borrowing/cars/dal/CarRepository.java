package com.example.demo.borrowing.cars.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {

    List<CarEntity> findAllByOrderByIdAsc();

}
