package com.example.demo.cars.dal;

import com.example.demo.cars.dal.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {

    List<CarEntity> findAllByOrderByIdAsc();

}
