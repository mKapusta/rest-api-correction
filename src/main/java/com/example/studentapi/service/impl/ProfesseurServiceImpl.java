package com.example.studentapi.service.impl;

import com.example.studentapi.dto.ProfesseurSearchCriteria;
import com.example.studentapi.dto.ProfesseurDto;
import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.ProfesseurJdbcRepository;
import com.example.studentapi.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    private ProfesseurJdbcRepository professeurRepository;

    @Override
    public List<ProfesseurDto> searchProfesseurs(ProfesseurSearchCriteria professeurSearchCriteria) {
        return professeurRepository.searchProfesseurs(professeurSearchCriteria.getNom(), professeurSearchCriteria.getPrenom()).stream()
                .map(professeur -> new ProfesseurDto(professeur))
                .collect(Collectors.toList());
    }

    @Override
    public ProfesseurDto getProfesseurById(Integer id) {
        return new ProfesseurDto(professeurRepository.getProfesseurById(id));
    }

    @Override
    public ProfesseurDto saveProfesseur(ProfesseurDto professeurDto) {
        Professeur professeur = fromProfesseurDto(professeurDto);
        Integer key = professeurRepository.saveProfesseur(professeur);
        professeurDto.setId(key);
        return professeurDto;
    }

    @Override
    public void deleteProfesseurById(Integer id) {
        professeurRepository.deleteProfesseurById(id);
    }

    @Override
    public ProfesseurDto updateProfesseur(Integer id, ProfesseurDto professeur) {
        professeur.setId(id);
        professeurRepository.updateProfesseur(fromProfesseurDto(professeur));
        return professeur;
    }

    private Professeur fromProfesseurDto(ProfesseurDto professeurDto) {
        Professeur professeur = new Professeur();
        professeur.setPrenom(professeurDto.getPrenom());
        professeur.setNom(professeurDto.getNom());
        professeur.setId(professeurDto.getId());
        return professeur;
    }
}
