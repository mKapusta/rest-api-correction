package com.example.studentapi.dto;

import com.example.studentapi.entity.Etudiant;

public class EtudiantDto {
    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;

    public EtudiantDto() {
    }

    public EtudiantDto(Etudiant etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.adresse = new AdresseDto(etudiant.getAdresse());
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

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }
}
