package com.example.studentapi.repository;

import com.example.studentapi.entity.Professeur;

import java.util.List;

public interface ProfesseurJdbcRepository {
    Professeur getProfesseurById(Integer id);

    List<Professeur> getAllProfesseurs();

    List<Professeur> searchProfesseurs(String nom, String prenom);

    Integer saveProfesseur(Professeur professeur);

    void deleteProfesseurById(Integer id);

    void updateProfesseur(Professeur professeur);
}
