package com.example.studentapi.service;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.EtudiantSearchCriteria;
import com.example.studentapi.dto.ResponsableDto;

import java.util.List;

public interface EtudiantService {

    List<EtudiantDto> getAllEtudiants(EtudiantSearchCriteria etudiantSearchCriteria);

    EtudiantDto getEtudiantById(Integer id);

    EtudiantDto saveEtudiant(EtudiantDto etudiantDto);

    void deleteEtudiant(Integer id);

    EtudiantDto updateEtudiant(Integer id, EtudiantDto etudiantDto);

    List<EtudiantDto> sortEtudiants(List<EtudiantDto> etudiants);

    List<ResponsableDto> getResponsablesOfAnEtudiant(Integer idEtudiant);
}
