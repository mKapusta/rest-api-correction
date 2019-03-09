package com.example.studentapi.repository;

import com.example.studentapi.entity.Cours;
import org.springframework.data.repository.CrudRepository;

public interface CoursJpaRepository extends CrudRepository<Cours, Integer> {
}
