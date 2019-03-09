package com.example.studentapi.repository;

import com.example.studentapi.entity.Cours;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursJpaRepository extends CrudRepository<Cours, Integer> {
    List<Cours> findByMatiereIsNull();
}
