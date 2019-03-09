package com.example.studentapi.repository.rowmapper;

import com.example.studentapi.entity.Cours;
import com.example.studentapi.entity.Professeur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CoursWithProfesseurRowMapper implements RowMapper<Cours> {
    @Override
    public Cours mapRow(ResultSet resultSet, int i) throws SQLException {
        Cours cours = new Cours();
        cours.setId( resultSet.getInt("COURS_ID"));
        cours.setProfesseur(new Professeur());
        cours.getProfesseur().setId( resultSet.getInt("PROF_ID"));
        cours.getProfesseur().setNom( resultSet.getString("PROF_NOM"));
        cours.getProfesseur().setPrenom( resultSet.getString("PROF_PRENOM"));
        cours.setId( resultSet.getInt("ID"));
        return cours;
    }
}
