package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.ProfesseurJdbcRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class ProfesseurJdbcRepositoryImplTest {

    @Autowired
    private ProfesseurJdbcRepository professeurJdbcRepository;

    @Test
    public void getProfesseurById() {
        Professeur professeur = professeurJdbcRepository.getProfesseurById(1);
        assertEquals("Clapton", professeur.getNom());
        assertEquals("Eric", professeur.getPrenom());
        assertEquals(Integer.valueOf(1), professeur.getId());
    }

    @Test
    public void searchProfesseurs_WithPrenom() {
        List<Professeur> professeurs = professeurJdbcRepository.searchProfesseurs("Clapton", null);
        assertEquals(1, professeurs.size());
        assertEquals("Clapton", professeurs.get(0).getNom());
        assertEquals("Clapton", professeurs.get(0).getNom());
        assertEquals("Eric", professeurs.get(0).getPrenom());
        assertEquals(Integer.valueOf(1), professeurs.get(0).getId());
    }

    @Test
    public void searchProfesseurs_WithNom() {
        List<Professeur> professeurs = professeurJdbcRepository.searchProfesseurs(null, "Eric");
        assertEquals(1, professeurs.size());
        assertEquals("Clapton", professeurs.get(0).getNom());
        assertEquals("Clapton", professeurs.get(0).getNom());
        assertEquals("Eric", professeurs.get(0).getPrenom());
        assertEquals(Integer.valueOf(1), professeurs.get(0).getId());
    }

    @Test
    public void searchProfesseurs_WithPrenomAndNom() {
        List<Professeur> professeurs = professeurJdbcRepository.searchProfesseurs("Clapton", "Eric");
        assertEquals(1, professeurs.size());
        assertEquals("Clapton", professeurs.get(0).getNom());
        assertEquals("Clapton", professeurs.get(0).getNom());
        assertEquals("Eric", professeurs.get(0).getPrenom());
        assertEquals(Integer.valueOf(1), professeurs.get(0).getId());
    }

    @Test
    public void saveProfesseur() {
        Professeur professeur = new Professeur();
        professeur.setNom("test");
        professeur.setPrenom("prenom");

        Integer key = professeurJdbcRepository.saveProfesseur(professeur);
        Professeur professeurSaved = professeurJdbcRepository.getProfesseurById(key);
        assertEquals("test", professeurSaved.getNom());
        assertEquals("prenom", professeurSaved.getPrenom());
        assertEquals(key, professeurSaved.getId());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteProfesseurById() {
        Integer key = professeurJdbcRepository.saveProfesseur(new Professeur());
        professeurJdbcRepository.deleteProfesseurById(key);
        professeurJdbcRepository.getProfesseurById(key);
    }

    @Test
    public void updateProfesseur() {
        Professeur professeur = new Professeur();
        professeur.setNom("test");
        professeur.setPrenom("prenom");

        Integer key = professeurJdbcRepository.saveProfesseur(professeur);
        professeur.setPrenom("test2");
        professeur.setId(key);
        professeurJdbcRepository.updateProfesseur(professeur);
        Professeur professeurUpdated = professeurJdbcRepository.getProfesseurById(key);
        assertEquals("test", professeurUpdated.getNom());
        assertEquals("test2", professeurUpdated.getPrenom());
        assertEquals(key, professeurUpdated.getId());
    }
}