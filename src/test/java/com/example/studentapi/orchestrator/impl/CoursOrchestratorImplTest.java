package com.example.studentapi.orchestrator.impl;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.service.CoursService;
import com.example.studentapi.service.EtudiantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoursOrchestratorImplTest {

    @InjectMocks
    private CoursOrchestratorImpl coursOrchestrator;

    @Mock
    private CoursService coursService;
    @Mock
    private EtudiantService etudiantService;

    @Test
    public void getCoursWithOrderedEtudiant() {
        List<EtudiantDto> etudiants = List.of(new EtudiantDto());
        when(coursService.getCoursById(1)).thenReturn(new CoursDto());
        when(etudiantService.sortEtudiants(null)).thenReturn(etudiants);
        CoursDto coursDto = coursOrchestrator.getCoursWithOrderedEtudiant(1);
        assertNotNull(coursDto);
        assertEquals(etudiants, coursDto.getEtudiants());
        verify(coursService).getCoursById(1);
        verify(etudiantService).sortEtudiants(null);
    }


}