package com.example.studentapi.dto;

import com.example.studentapi.entity.Adresse;

public class AdresseDto {
    private Integer id;
    private String ville;
    private Integer distance;

    public AdresseDto() {
    }

    public AdresseDto(Adresse adresse) {
        if (adresse != null) {
            this.id = adresse.getId();
            this.ville = adresse.getVille();
            this.distance = adresse.getDistance();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
