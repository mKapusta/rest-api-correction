package com.example.studentapi.controller;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.EtudiantSearchCriteria;
import com.example.studentapi.service.EtudiantService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
@Validated
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @RequestMapping("")
    public List<EtudiantDto> getAllEtudiants(EtudiantSearchCriteria etudiantSearchCriteria) {
        return etudiantService.getAllEtudiants(etudiantSearchCriteria);
    }

    @RequestMapping("/{id}")
    public EtudiantDto getEtudiantById(@PathVariable @Range(min=1) Integer id) {
        return etudiantService.getEtudiantById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public EtudiantDto saveEtudiant(@Valid @RequestBody EtudiantDto etudiantDto) {
        return etudiantService.saveEtudiant(etudiantDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteEtudiantById(@PathVariable @Range(min=1) Integer id) {
        etudiantService.deleteEtudiant(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public EtudiantDto updateEtudiant(@PathVariable Integer id,@Valid @RequestBody EtudiantDto etudiantDto) {
        return etudiantService.updateEtudiant(id, etudiantDto);
    }
}
