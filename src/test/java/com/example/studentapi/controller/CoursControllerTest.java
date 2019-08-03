package com.example.studentapi.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.orchestrator.CoursOrchestrator;
import com.example.studentapi.service.CoursService;

@RunWith(MockitoJUnitRunner.class)
public class CoursControllerTest {

    @Mock
    private CoursService coursService;

    @Mock
    private CoursOrchestrator coursOrchestrator;

    @InjectMocks
    private CoursController coursController;

    private CoursDto cours;

    @Before
    public void setUp() throws Exception {
        cours = new CoursDto();
        when(coursService.getCoursWithProfesseur(Integer.valueOf(1))).thenReturn(cours);
        when(coursOrchestrator.getCoursWithOrderedEtudiant(Integer.valueOf(1))).thenReturn(cours);
        when(coursService.saveCours(any(CoursDto.class))).thenReturn(cours);
        when(coursService.searchCours(false)).thenReturn(List.of(cours));
    }

    @Test
    public void getCoursWithProfesseur() throws MissingEntityException {
        CoursDto coursDto = coursController.getCoursWithProfesseur(Integer.valueOf(1));
        assertEquals(cours, coursDto);
        verify(coursService).getCoursWithProfesseur(Integer.valueOf(1));
    }

    @Test
    public void getCoursWithProfesseurResponseEntity() throws MissingEntityException {
        ResponseEntity<CoursDto> responseEntity = coursController.getCoursWithProfesseurResponseEntity(Integer.valueOf(1));
        assertEquals(cours,responseEntity.getBody());
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        verify(coursService).getCoursWithProfesseur(Integer.valueOf(1));

    }

    @Test
    public void getCoursWithProfesseurResponseEntity_whenMissingEntityException() throws MissingEntityException {
        when(coursService.getCoursWithProfesseur(Integer.valueOf(1))).thenThrow(new MissingEntityException());
        ResponseEntity<CoursDto> responseEntity = coursController.getCoursWithProfesseurResponseEntity(Integer.valueOf(1));
        assertNull(responseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
        verify(coursService).getCoursWithProfesseur(Integer.valueOf(1));

    }


    @Test
    public void saveCours() {
        CoursDto coursDto = coursController.saveCours(cours);
        assertEquals(cours, coursDto);
        verify(coursService).saveCours(cours);
    }

    @Test
    public void getAllCours() {
        List<CoursDto> coursDtoList = coursController.getAllCours(false);
        assertEquals(cours, coursDtoList.get(0));
        verify(coursService).searchCours(false);


    }

    @Test
    public void getCoursById() {
        CoursDto coursDto = coursController.getCoursById(Integer.valueOf(1));
        assertEquals(cours, coursDto);
        verify(coursOrchestrator).getCoursWithOrderedEtudiant(Integer.valueOf(1));
    }
}