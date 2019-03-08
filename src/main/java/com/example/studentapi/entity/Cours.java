package com.example.studentapi.entity;

import java.util.List;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.MatiereDto;
import com.example.studentapi.dto.ProfesseurDto;

public class Cours {
    private Integer id;
    private List<EtudiantDto> etudiantDtos;
    private MatiereDto matiere;
    private ProfesseurDto professeur;

}
