package com.example.studentapi.repository;

import com.example.studentapi.entity.Cours;

public interface CoursJdbcRepository {
    Cours getCoursWithProfesseur(Integer id);
}
