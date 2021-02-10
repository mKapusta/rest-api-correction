package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Cours;
import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.CoursJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class CoursRepositoryImpl implements CoursJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Cours getCoursWithProfesseur(Integer id) {
        return jdbcTemplate.query("SELECT C.ID as COURS_ID, P.NOM as PROF_NOM, P.PRENOM as PROF_PRENOM," +
                        " P.ID as PROF_ID, E.ID as ETU_ID, E.NOM as ETU_NOM, E.PRENOM as ETU_PRENOM" +
                        " FROM COURS C INNER JOIN PROFESSEUR P ON P.ID = C.ID_PROFESSEUR " +
                        " INNER JOIN SUIT_COURS SC ON SC.ID_COURS = C.ID " +
                        " INNER JOIN ETUDIANT E ON E.ID = SC.ID_ETUDIANT" +
                        " WHERE C.ID = ?",
                        new ResultSetExtractor<Cours>(){

                            public Cours extractData(
                                    ResultSet rs) throws SQLException, DataAccessException {

                                Cours cours = new Cours();
                                cours.setEtudiants(new ArrayList<>());
                                while(rs.next()){
                                    cours.setId( rs.getInt("COURS_ID"));
                                    cours.setProfesseur(new Professeur());
                                    cours.getProfesseur().setId( rs.getInt("PROF_ID"));
                                    cours.getProfesseur().setNom( rs.getString("PROF_NOM"));
                                    cours.getProfesseur().setPrenom( rs.getString("PROF_PRENOM"));
                                    Etudiant etudiant = new Etudiant();
                                    etudiant.setId(rs.getInt("ETU_ID"));
                                    etudiant.setNom(rs.getString("ETU_NOM"));
                                    etudiant.setPrenom(rs.getString("ETU_PRENOM"));
                                    cours.getEtudiants().add(etudiant);
                                }
                                return cours;
                            }
                        },
                id);
    }
}
