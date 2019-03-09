package com.example.studentapi.service.impl;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.entity.Cours;
import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.entity.Matiere;
import com.example.studentapi.entity.Professeur;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.repository.CoursJdbcRepository;
import com.example.studentapi.repository.CoursJpaRepository;
import com.example.studentapi.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursServiceImpl implements CoursService {
    @Autowired
    private CoursJdbcRepository coursRepository;

    @Autowired
    private CoursJpaRepository coursJpaRepository;

    @Override
    public CoursDto getCoursWithProfesseur(Integer id) throws MissingEntityException {
        try {
            return new CoursDto(coursRepository.getCoursWithProfesseur(id));
        } catch (EmptyResultDataAccessException e) {
            throw new MissingEntityException();
        }
    }

    @Override
    public CoursDto getCoursById(Integer id) {
        return new CoursDto(coursJpaRepository.findById(id).get());
    }

    @Override
    public CoursDto saveCours(CoursDto cours) {
        return new CoursDto(coursJpaRepository.save(fromCoursDto(cours)));
    }

    @Override
    public List<CoursDto> getAllCours() {
        List<CoursDto> cours = new ArrayList<>();
        coursJpaRepository.findAll().forEach(
                coursEntity -> cours.add(new CoursDto(coursEntity))
        );
        return cours;
    }

    private Cours fromCoursDto(CoursDto coursDto) {
        Cours cours = new Cours();
        cours.setId(coursDto.getId());
        if (coursDto.getProfesseur() != null) {
            Professeur professeur = new Professeur();
            professeur.setId(coursDto.getProfesseur().getId());
            cours.setProfesseur(professeur);
        }
        if (coursDto.getMatiere() != null) {
            Matiere matiere = new Matiere();
            cours.setId(coursDto.getMatiere().getId());
            cours.setMatiere(matiere);
        }
        if (coursDto.getEtudiants() != null) {
            cours.setEtudiants(coursDto.getEtudiants().stream()
                    .map(etudiantDto -> new Etudiant(etudiantDto.getId()))
                    .collect(Collectors.toList()));
        }
        return cours;
    }


}
