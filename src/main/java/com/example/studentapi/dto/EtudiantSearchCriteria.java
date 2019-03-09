package com.example.studentapi.dto;

public class EtudiantSearchCriteria {

    private String nom;
    private String prenom;

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

    public boolean hasNoCriteria() {
        return nom == null && prenom == null;
    }
}
