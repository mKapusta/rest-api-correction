package com.example.studentapi.service;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;

import java.util.List;

public interface CoursService {

    CoursDto getCoursWithProfesseur(Integer id) throws MissingEntityException;

    CoursDto getCoursById(Integer id);

    CoursDto saveCours(CoursDto cours);

    List<CoursDto> searchCours(Boolean withoutMatiere);
}
