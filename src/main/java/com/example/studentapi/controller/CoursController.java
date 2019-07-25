package com.example.studentapi.controller;

import javax.validation.Valid;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.orchestrator.CoursOrchestrator;
import com.example.studentapi.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @Autowired
    private CoursOrchestrator coursOrchestrator;

    @RequestMapping("/jdbc/{id}")
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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CoursDto saveCours(@RequestBody @Valid CoursDto coursDto) {
        return coursService.saveCours(coursDto);
    }

    @RequestMapping(value = "")
    public List<CoursDto> getAllCours(@RequestParam(required = false) Boolean withoutMatiere) {
        return coursService.searchCours(withoutMatiere);
    }

    @RequestMapping("/{id}")
    public CoursDto getCoursById(@PathVariable Integer id) {
        return coursOrchestrator.getCoursWithOrderedEtudiant(id);
    }
}
