package com.example.studentapi.repository;

import com.example.studentapi.entity.Cours;

public interface CoursRepository {
    Cours getCoursWithProfesseur(Integer id);
}
