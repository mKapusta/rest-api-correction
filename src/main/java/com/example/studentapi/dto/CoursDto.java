package com.example.studentapi.dto;

import com.example.studentapi.entity.Cours;

import java.util.List;
import java.util.stream.Collectors;

public class CoursDto {
    private Integer id;
    private List<EtudiantDto> etudiants;
    private MatiereDto matiere;
    private ProfesseurDto professeur;

    public CoursDto(){}

    public CoursDto(Cours cours) {
        this.id = cours.getId();
        if (cours.getEtudiants() != null) {
            this.etudiants = cours.getEtudiants().stream().map(etudiant -> new EtudiantDto(etudiant)).collect(Collectors.toList());
        }
        if (cours.getMatiere() != null) {
            this.matiere = new MatiereDto(cours.getMatiere());
        }
        if (cours.getProfesseur() != null) {
            this.professeur = new ProfesseurDto(cours.getProfesseur());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EtudiantDto> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<EtudiantDto> etudiants) {
        this.etudiants = etudiants;
    }

    public MatiereDto getMatiere() {
        return matiere;
    }

    public void setMatiere(MatiereDto matiere) {
        this.matiere = matiere;
    }

    public ProfesseurDto getProfesseur() {
        return professeur;
    }

    public void setProfesseur(ProfesseurDto professeur) {
        this.professeur = professeur;
    }
}
