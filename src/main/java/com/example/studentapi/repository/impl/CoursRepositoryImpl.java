package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Cours;
import com.example.studentapi.repository.CoursRepository;
import com.example.studentapi.repository.rowmapper.CoursWithProfesseurRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoursRepositoryImpl implements CoursRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Cours getCoursWithProfesseur(Integer id) {
        return jdbcTemplate.queryForObject("SELECT C.ID as COURS_ID, P.NOM as PROF_NOM, P.PRENOM as PROF_PRENOM," +
                        " P.ID as PROF_ID FROM COURS C INNER JOIN PROFESSEUR P ON P.ID = C.ID_PROFESSEUR WHERE C.ID = ?",
                new CoursWithProfesseurRowMapper(),
                id);
    }
}
