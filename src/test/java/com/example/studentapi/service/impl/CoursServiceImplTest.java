package com.example.studentapi.service.impl;

import com.example.studentapi.dto.CoursDto;
import com.example.studentapi.dto.MatiereDto;
import com.example.studentapi.dto.ProfesseurDto;
import com.example.studentapi.entity.Cours;
import com.example.studentapi.entity.Matiere;
import com.example.studentapi.entity.Professeur;
import com.example.studentapi.exception.MissingEntityException;
import com.example.studentapi.repository.CoursJdbcRepository;
import com.example.studentapi.repository.CoursJpaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoursServiceImplTest {

    @InjectMocks
    private CoursServiceImpl coursService;

    @Mock
    private CoursJpaRepository coursJpaRepository;
    @Mock
    private CoursJdbcRepository coursJdbcRepository;

    @Before
    public void setUp() throws Exception {
        when(coursJdbcRepository.getCoursWithProfesseur(1)).thenReturn(createCours());
        when(coursJpaRepository.findAll()).thenReturn(List.of(createCours()));
        when(coursJpaRepository.findByMatiereIsNull()).thenReturn(List.of(createCours()));
        when(coursJpaRepository.save(any(Cours.class))).thenReturn(createCours());
        when(coursJpaRepository.findById(1)).thenReturn(Optional.of(createCours()));
    }

    private Cours createCours() {
        Cours cours = new Cours();
        cours.setId(1);
        cours.setMatiere(new Matiere());
        cours.setProfesseur(new Professeur());
        cours.setEtudiants(new ArrayList<>());
        return cours;
    }

    private CoursDto createCoursDto() {
        CoursDto cours = new CoursDto();
        cours.setId(1);
        cours.setMatiere(new MatiereDto());
        cours.setProfesseur(new ProfesseurDto());
        cours.setEtudiants(new ArrayList<>());
        return cours;
    }


    @Test
    public void getCoursWithProfesseur() throws MissingEntityException {
        CoursDto coursDto = coursService.getCoursWithProfesseur(1);
        assertNotNull(coursDto.getEtudiants());
        assertNotNull(coursDto.getMatiere());
        assertNotNull(coursDto.getProfesseur());
        assertEquals(Integer.valueOf(1), coursDto.getId());
        verify(coursJdbcRepository).getCoursWithProfesseur(1);
    }

    @Test(expected = MissingEntityException.class)
    public void getCoursWithProfesseur_WhenNoEntity() throws MissingEntityException {
        when(coursJdbcRepository.getCoursWithProfesseur(1)).thenThrow(new EmptyResultDataAccessException(0));
        coursService.getCoursWithProfesseur(1);
    }

    @Test
    public void getCoursById() {
        CoursDto coursDto = coursService.getCoursById(1);
        assertNotNull(coursDto.getEtudiants());
        assertNotNull(coursDto.getMatiere());
        assertNotNull(coursDto.getProfesseur());
        assertEquals(Integer.valueOf(1), coursDto.getId());

        verify(coursJpaRepository).findById(1);
    }

    @Test
    public void saveCours() {
        CoursDto coursDto = coursService.saveCours(createCoursDto());
        assertNotNull(coursDto.getEtudiants());
        assertNotNull(coursDto.getMatiere());
        assertNotNull(coursDto.getProfesseur());
        assertEquals(Integer.valueOf(1), coursDto.getId());

        verify(coursJpaRepository).save(any(Cours.class));
    }

    @Test
    public void searchCours_withoutMatiere() {
        List<CoursDto> coursDto = coursService.searchCours(true);
        assertNotNull(coursDto.get(0).getEtudiants());
        assertNotNull(coursDto.get(0).getMatiere());
        assertNotNull(coursDto.get(0).getProfesseur());
        assertEquals(Integer.valueOf(1), coursDto.get(0).getId());

        verify(coursJpaRepository).findByMatiereIsNull();
    }

    @Test
    public void searchCours() {
        List<CoursDto> coursDto = coursService.searchCours(false);
        assertNotNull(coursDto.get(0).getEtudiants());
        assertNotNull(coursDto.get(0).getMatiere());
        assertNotNull(coursDto.get(0).getProfesseur());
        assertEquals(Integer.valueOf(1), coursDto.get(0).getId());

        verify(coursJpaRepository).findAll();
    }
}