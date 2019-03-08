package com.example.studentapi.dto;

import java.util.List;

public class CoursDto {
    private Integer id;
    private List<EtudiantDto> etudiants;
    private MatiereDto matiere;
    private ProfesseurDto professeur;

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
