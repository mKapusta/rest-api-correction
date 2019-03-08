package com.example.studentapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.studentapi.entity.Etudiant;

@Repository
public class EtudiantJdbcRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Etudiant getStudentById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT ID,NOM,PRENOM FROM ETUDIANT WHERE ID = ?", new BeanPropertyRowMapper<>(), id);
    }

    public List<Etudiant> getAllStudents() {
        return jdbcTemplate.query("SELECT ID,NOM,PRENOM FROM ETUDIANT", new BeanPropertyRowMapper<>());
    }

    public List<Etudiant> saveStudent() {
        jdbcTemplate.update("INSERT INTO ETUDIANT(NOM,PRENOM) VALUES (?,?)");
    }

}
