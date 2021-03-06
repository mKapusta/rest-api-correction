package com.example.studentapi.dto;

import com.example.studentapi.entity.Matiere;

public class MatiereDto {

    private Integer id;
    private String nom;

    public MatiereDto() {
    }

    public MatiereDto(Matiere matiere) {
        this.id = matiere.getId();
        this.nom = matiere.getNom();
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
}
