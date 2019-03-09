package com.example.studentapi.service.impl;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.repository.CoursRepository;
import com.example.studentapi.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CoursServiceImpl implements CoursService {
    @Autowired
    private CoursRepository coursRepository;

    @Override
    public CoursDto getCoursWithProfesseur(Integer id) throws MissingEntityException {
        try {
            return new CoursDto(coursRepository.getCoursWithProfesseur(id));
        } catch (EmptyResultDataAccessException e) {
            throw new MissingEntityException();
        }
    }
}
