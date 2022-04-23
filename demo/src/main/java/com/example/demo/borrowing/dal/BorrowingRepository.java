package com.example.demo.borrowing.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BorrowingRepository extends CrudRepository<BorrowingEntity, Integer> {
    @Override
    List<BorrowingEntity> findAll();
}
