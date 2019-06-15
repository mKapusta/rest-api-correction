package com.example.studentapi.repository;

import com.example.studentapi.entity.Adresse;

import java.util.List;

public interface AdresseHibernateRepository {

    Adresse getAdresseById(Integer id);

    List<Adresse> getFurthestAdresses();

    void saveAdresse(Adresse adresse);

    void deleteAdresseById(Integer id);

    void updateAdresse(Integer Id, Adresse adresse);

    List<Adresse> getAllAdresses();
}
