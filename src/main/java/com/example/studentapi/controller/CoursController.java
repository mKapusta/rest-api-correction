package com.example.studentapi.controller;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.orchestrator.CoursOrchestrator;
import com.example.studentapi.service.CoursService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cours")
@Validated
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
    public ResponseEntity<CoursDto> getCoursWithProfesseurResponseEntity(@PathVariable  @Range(min = 1) Integer id) {
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
    public CoursDto getCoursById(@PathVariable @Range(min = 1) Integer id) {
        return coursOrchestrator.getCoursWithOrderedEtudiant(id);
    }
}
