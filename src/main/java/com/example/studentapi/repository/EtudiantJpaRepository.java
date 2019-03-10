package com.example.studentapi.repository;

import com.example.studentapi.entity.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EtudiantJpaRepository extends CrudRepository<Etudiant, Integer> {

    List<Etudiant> findByPrenom(String prenom);

    @Query("SELECT e from Etudiant e where e.nom= :nom and e.prenom = :prenom")
    List<Etudiant> trouverParNomEtPrenom(String nom, String prenom);

    List<Etudiant> findByNom(String nom);
}
