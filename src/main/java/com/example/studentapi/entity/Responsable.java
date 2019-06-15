package com.example.studentapi.entity;

import javax.persistence.*;

@Entity
public class Responsable {
    @Id
    private Integer id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;


    public Responsable(Integer id) {
        this.id = id;
    }

    public Responsable() {

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

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
