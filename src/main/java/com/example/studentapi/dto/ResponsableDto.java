package com.example.studentapi.dto;

import com.example.studentapi.entity.Responsable;

public class ResponsableDto {
    private Integer id;
    private String nom;
    private String prenom;

    public ResponsableDto(Responsable responsable) {
        this.id = responsable.getId();
        this.nom = responsable.getNom();
        this.prenom = responsable.getPrenom();
    }

    public ResponsableDto() {

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
