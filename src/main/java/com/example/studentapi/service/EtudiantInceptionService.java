package com.example.studentapi.service;

import com.example.studentapi.dto.EtudiantDto;

import java.util.List;

public interface EtudiantInceptionService {

    List<EtudiantDto> getAllEtudiants();

    EtudiantDto getEtudiantById(Integer id);

}
