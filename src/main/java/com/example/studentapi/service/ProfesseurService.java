package com.example.studentapi.service;

import com.example.studentapi.dto.ProfesseurSearchCriteria;
import com.example.studentapi.dto.ProfesseurDto;

import java.util.List;

public interface ProfesseurService {

    List<ProfesseurDto> searchProfesseurs(ProfesseurSearchCriteria professeurSearchCriteria);

    ProfesseurDto getProfesseurById(Integer id);

    ProfesseurDto saveProfesseur(ProfesseurDto professeur);

    void deleteProfesseurById(Integer id);

    ProfesseurDto updateProfesseur(Integer id, ProfesseurDto professeur);
}
