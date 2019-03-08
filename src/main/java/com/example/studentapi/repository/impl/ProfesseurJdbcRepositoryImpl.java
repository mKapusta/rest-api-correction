package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@Qualifier("jdbcRepository")
public class ProfesseurJdbcRepositoryImpl implements ProfesseurRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Professeur getProfesseurById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT ID,NOM,PRENOM FROM PROFESSEUR WHERE ID = ?",
                new BeanPropertyRowMapper<>(Professeur.class), id);
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        return jdbcTemplate.query("SELECT ID,NOM,PRENOM FROM PROFESSEUR", new BeanPropertyRowMapper<>(Professeur.class));
    }

    @Override
    public Integer saveProfesseur(Professeur professeur) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatement ps = null;
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO PROFESSEUR(NOM,PRENOM) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, professeur.getNom());
                ps.setString(2, professeur.getPrenom());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

}
