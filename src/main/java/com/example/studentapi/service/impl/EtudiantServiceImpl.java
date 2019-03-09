package com.example.studentapi.service.impl;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.repository.EtudiantJpaRepository;
import com.example.studentapi.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    private EtudiantJpaRepository etudiantJpaRepository;

    @Override
    public List<EtudiantDto> getAllEtudiants() {
        List<EtudiantDto> etudiants = new ArrayList<>();
        etudiantJpaRepository.findAll().forEach(
                etudiant -> etudiants.add(new EtudiantDto(etudiant))
        );
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

    private Etudiant fromEtudiantDto(EtudiantDto etudiantDto) {
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenom(etudiantDto.getPrenom());
        etudiant.setNom(etudiantDto.getNom());
        etudiant.setId(etudiantDto.getId());
        return etudiant;
    }
}
