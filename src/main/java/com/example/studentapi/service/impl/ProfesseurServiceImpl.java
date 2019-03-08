package com.example.studentapi.service.impl;

import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.ProfesseurRepository;
import com.example.studentapi.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Override
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.getAllProfesseurs();
    }

    @Override
    public Professeur getProfesseurById(Integer id) {
        return professeurRepository.getProfesseurById(id);
    }

    @Override
    public Professeur saveProfesseur(Professeur professeur) {
        Integer key =  professeurRepository.saveProfesseur(professeur);
        professeur.setId(key);
        return professeur;
    }
}
