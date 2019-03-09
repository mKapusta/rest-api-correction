package com.example.studentapi.orchestrator;

import com.example.studentapi.dto.CoursDto;

public interface CoursOrchestrator {

    CoursDto getCoursWithOrderedEtudiant(Integer id);
}
