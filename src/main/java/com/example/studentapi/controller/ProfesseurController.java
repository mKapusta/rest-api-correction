package com.example.studentapi.controller;

import com.example.studentapi.entity.Professeur;
import com.example.studentapi.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @RequestMapping("")
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }
    @RequestMapping("/{id}")
    public Professeur getProfesseurById(@PathVariable Integer id) {
        return professeurService.getProfesseurById(id);
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Professeur saveProfesseur(@RequestBody Professeur professeur) {
        return professeurService.saveProfesseur(professeur);
    }
}
