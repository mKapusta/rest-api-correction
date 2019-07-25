package com.example.studentapi.dto;

import javax.validation.constraints.NotBlank;

import com.example.studentapi.entity.Professeur;

public class ProfesseurDto {
    private Integer id;
    @NotBlank(message = "Nom obligatoire")
    private String nom;
    private String prenom;

    public ProfesseurDto() {
    }

    public ProfesseurDto(Professeur professeur) {
        this.id = professeur.getId();
        this.nom = professeur.getNom();
        this.prenom = professeur.getPrenom();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
