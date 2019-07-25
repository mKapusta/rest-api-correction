package com.example.studentapi.controller;

import javax.validation.Valid;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.EtudiantSearchCriteria;
import com.example.studentapi.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @RequestMapping("")
    public List<EtudiantDto> getAllEtudiants(EtudiantSearchCriteria etudiantSearchCriteria) {
        return etudiantService.getAllEtudiants(etudiantSearchCriteria);
    }

    @RequestMapping("/{id}")
    public EtudiantDto getEtudiantById(@PathVariable Integer id) {
        return etudiantService.getEtudiantById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public EtudiantDto saveEtudiant(@Valid @RequestBody EtudiantDto etudiantDto) {
        return etudiantService.saveEtudiant(etudiantDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEtudiantById(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public EtudiantDto updateEtudiant(@PathVariable Integer id, @RequestBody EtudiantDto etudiantDto) {
        return etudiantService.updateEtudiant(id, etudiantDto);
    }
}
