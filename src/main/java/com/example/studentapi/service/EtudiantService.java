package com.example.studentapi.service;

import com.example.studentapi.dto.EtudiantDto;

import java.util.List;

public interface EtudiantService {

    List<EtudiantDto> getAllEtudiants();

    EtudiantDto getEtudiantById(Integer id);

    EtudiantDto saveEtudiant(EtudiantDto etudiantDto);

    void deleteEtudiant(Integer id);

    EtudiantDto updateEtudiant(Integer id, EtudiantDto etudiantDto);
}
