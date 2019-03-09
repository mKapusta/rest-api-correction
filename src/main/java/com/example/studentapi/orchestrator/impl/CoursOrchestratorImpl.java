package com.example.studentapi.orchestrator.impl;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.orchestrator.CoursOrchestrator;
import com.example.studentapi.service.CoursService;
import com.example.studentapi.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursOrchestratorImpl implements CoursOrchestrator {
    @Autowired
    private CoursService coursService;

    @Autowired
    private EtudiantService etudiantService;

    @Override
    public CoursDto getCoursWithOrderedEtudiant(Integer id) {
        CoursDto coursDto = coursService.getCoursById(id);
        coursDto.setEtudiants(etudiantService.sortEtudiants(coursDto.getEtudiants()));
        return coursDto;
    }
}
