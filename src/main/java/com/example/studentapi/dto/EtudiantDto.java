package com.example.studentapi.dto;

import javax.validation.constraints.NotBlank;

import com.example.studentapi.entity.Etudiant;

public class EtudiantDto {
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String nom;
    private String prenom;

    public EtudiantDto() {
    }

    public EtudiantDto(Etudiant etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
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
