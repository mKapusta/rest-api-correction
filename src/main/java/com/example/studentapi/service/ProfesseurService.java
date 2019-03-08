package com.example.studentapi.service;

import com.example.studentapi.entity.Professeur;

import java.util.List;

public interface ProfesseurService {

    List<Professeur> getAllProfesseurs();

    Professeur getProfesseurById(Integer id);

    Professeur saveProfesseur(Professeur professeur);
}
