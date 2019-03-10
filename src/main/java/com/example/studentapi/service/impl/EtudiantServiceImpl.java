package com.example.studentapi.service.impl;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.EtudiantSearchCriteria;
import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.repository.EtudiantJpaRepository;
import com.example.studentapi.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantJpaRepository etudiantJpaRepository;

    @Override
    public List<EtudiantDto> getAllEtudiants(EtudiantSearchCriteria etudiantSearchCriteria) {
        List<EtudiantDto> etudiants = new ArrayList<>();
        Iterable<Etudiant> etudiantsEntity = null;
        if (etudiantSearchCriteria == null || etudiantSearchCriteria.hasNoCriteria()) {
            etudiantsEntity = etudiantJpaRepository.findAll();
        } else if (etudiantSearchCriteria.getNom() != null && etudiantSearchCriteria.getPrenom() != null) {
            etudiantsEntity = etudiantJpaRepository.
                    trouverParNomEtPrenom(etudiantSearchCriteria.getNom(), etudiantSearchCriteria.getPrenom());
        } else if (etudiantSearchCriteria.getPrenom() != null) {
            etudiantsEntity = etudiantJpaRepository.findByPrenom(etudiantSearchCriteria.getPrenom());
        } else if (etudiantSearchCriteria.getNom() != null) {
            etudiantsEntity = etudiantJpaRepository.findByNom(etudiantSearchCriteria.getNom());
        }
        etudiantsEntity.forEach(
                etudiant -> etudiants.add(new EtudiantDto(etudiant)));
        return etudiants;
    }

    @Override
    public EtudiantDto getEtudiantById(Integer id) {
        return new EtudiantDto(etudiantJpaRepository.findById(id).get());
    }

    @Override
    public EtudiantDto saveEtudiant(EtudiantDto etudiantDto) {
        return new EtudiantDto(etudiantJpaRepository.save(fromEtudiantDto(etudiantDto)));
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantJpaRepository.deleteById(id);
    }

    @Override
    public EtudiantDto updateEtudiant(Integer id, EtudiantDto etudiantDto) {
        return new EtudiantDto(etudiantJpaRepository.save(fromEtudiantDto(etudiantDto)));

    }

    @Override
    public List<EtudiantDto> sortEtudiants(List<EtudiantDto> etudiants) {
        return etudiants.stream().sorted(Comparator.comparing(EtudiantDto::getId)).collect(Collectors.toList());
    }

    private Etudiant fromEtudiantDto(EtudiantDto etudiantDto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenom(etudiantDto.getPrenom());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setId(etudiantDto.getId());
        return etudiant;
    }
}
