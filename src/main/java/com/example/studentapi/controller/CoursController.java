package com.example.studentapi.controller;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @RequestMapping("/{id}")
    public CoursDto getCoursWithProfesseur(@PathVariable Integer id) throws MissingEntityException {
        return coursService.getCoursWithProfesseur(id);
    }

    @RequestMapping("/responseEntity/{id}")
    public ResponseEntity<CoursDto> getCoursWithProfesseurResponseEntity(@PathVariable Integer id) {
        ResponseEntity responseEntity = null;
        try {
            return ResponseEntity.ok().body(coursService.getCoursWithProfesseur(id));
        } catch (MissingEntityException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
