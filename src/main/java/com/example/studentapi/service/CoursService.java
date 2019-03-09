package com.example.studentapi.service;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;

public interface CoursService {

   CoursDto getCoursWithProfesseur(Integer id) throws MissingEntityException;
}
