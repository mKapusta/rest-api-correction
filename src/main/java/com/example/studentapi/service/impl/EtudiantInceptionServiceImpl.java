package com.example.studentapi.service.impl;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.repository.EtudiantInceptionRepository;
import com.example.studentapi.service.EtudiantInceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudiantInceptionServiceImpl implements EtudiantInceptionService {
    @Autowired
    private EtudiantInceptionRepository etudiantInceptionRepository;


    @Override
    public List<EtudiantDto> getAllEtudiants() {
        return etudiantInceptionRepository.getAllStudents().stream()
                .map(etudiant -> new EtudiantDto(etudiant))
                .collect(Collectors.toList());
    }

    @Override
    public EtudiantDto getEtudiantById(Integer id) {
        return new EtudiantDto(etudiantInceptionRepository.getStudentById(id));
    }
}
