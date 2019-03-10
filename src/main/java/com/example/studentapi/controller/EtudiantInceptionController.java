package com.example.studentapi.controller;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.service.EtudiantInceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inception/etudiants")
public class EtudiantInceptionController {
    @Autowired
    private EtudiantInceptionService etudiantInceptionService;

    @RequestMapping("")
    public List<EtudiantDto> getAllEtudiants() {
        return etudiantInceptionService.getAllEtudiants();
    }

    @RequestMapping("/{id}")
    public EtudiantDto getEtudiantById(@PathVariable Integer id) {
        return etudiantInceptionService.getEtudiantById(id);
    }
}
