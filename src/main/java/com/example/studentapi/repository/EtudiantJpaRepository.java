package com.example.studentapi.repository;

import com.example.studentapi.entity.Etudiant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EtudiantJpaRepository extends CrudRepository<Etudiant, Integer> {

    List<Etudiant> findByPrenom(String prenom);

    List<Etudiant> findByNomAndPrenom(String nom, String prenom);

    List<Etudiant> findByNom(String nom);
}
