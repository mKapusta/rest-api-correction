package com.example.studentapi.repository;

import com.example.studentapi.entity.Professeur;

import java.util.List;

public interface ProfesseurRepository {
    Professeur getProfesseurById(Integer id);

    List<Professeur> getAllProfesseurs();

    Integer saveProfesseur(Professeur professeur);
}
