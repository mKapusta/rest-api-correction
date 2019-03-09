package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.ProfesseurJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
public class ProfesseurJdbcRepositoryImpl implements ProfesseurJdbcRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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

    @Override
    public void deleteProfesseurById(Integer id) {
        jdbcTemplate.update("DELETE FROM PROFESSEUR WHERE ID = ?", id);
    }

    @Override
    public void updateProfesseur(Professeur professeur) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        ((MapSqlParameterSource) sqlParameterSource).addValue("nom", professeur.getNom());
        ((MapSqlParameterSource) sqlParameterSource).addValue("prenom", professeur.getPrenom());
        ((MapSqlParameterSource) sqlParameterSource).addValue("id", professeur.getId());
        namedParameterJdbcTemplate.update("UPDATE PROFESSEUR SET NOM = :nom, PRENOM = :prenom WHERE ID = :id",
                sqlParameterSource);
    }

}
