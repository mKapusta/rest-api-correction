package com.example.studentapi.service.impl;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.EtudiantSearchCriteria;
import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.repository.EtudiantJpaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EtudiantServiceImplTest {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantJpaRepository etudiantJpaRepository;

    @Before
    public void init() {
        when(etudiantJpaRepository.findByPrenom(anyString())).thenReturn(List.of(createEtudiant()));
        when(etudiantJpaRepository.findByNom(anyString())).thenReturn(List.of(createEtudiant()));
        when(etudiantJpaRepository.findAll()).thenReturn(List.of(createEtudiant()));
        when(etudiantJpaRepository.trouverParNomEtPrenom(anyString(), anyString())).thenReturn(List.of(createEtudiant()));
        when(etudiantJpaRepository.save(any(Etudiant.class))).thenReturn(createEtudiant());
        when(etudiantJpaRepository.findById(1)).thenReturn(Optional.of(createEtudiant()));
    }

    private Etudiant createEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        etudiant.setNom("nom");
        etudiant.setPrenom("prenom");
        return etudiant;
    }

    @Test
    public void getAllEtudiants_WithoutCriteria() {
        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiants(null);
        assertEquals(1, etudiantDtos.size());
        assertEquals(Integer.valueOf(1), etudiantDtos.get(0).getId());
        assertEquals("nom", etudiantDtos.get(0).getNom());
        assertEquals("prenom", etudiantDtos.get(0).getPrenom());
        verify(etudiantJpaRepository).findAll();
        verifyNoMoreInteractions(etudiantJpaRepository);
    }


    @Test
    public void getAllEtudiants_WithNom() {
        EtudiantSearchCriteria etudiantSearchCriteria = new EtudiantSearchCriteria();
        etudiantSearchCriteria.setNom("nom");
        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiants(etudiantSearchCriteria);
        assertEquals(1, etudiantDtos.size());
        assertEquals(Integer.valueOf(1), etudiantDtos.get(0).getId());
        assertEquals("nom", etudiantDtos.get(0).getNom());
        assertEquals("prenom", etudiantDtos.get(0).getPrenom());
        verify(etudiantJpaRepository).findByNom("nom");
        verifyNoMoreInteractions(etudiantJpaRepository);
    }

    @Test
    public void getAllEtudiants_WithPrenom() {
        EtudiantSearchCriteria etudiantSearchCriteria = new EtudiantSearchCriteria();
        etudiantSearchCriteria.setPrenom("prenom");
        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiants(etudiantSearchCriteria);
        assertEquals(1, etudiantDtos.size());
        assertEquals(Integer.valueOf(1), etudiantDtos.get(0).getId());
        assertEquals("nom", etudiantDtos.get(0).getNom());
        assertEquals("prenom", etudiantDtos.get(0).getPrenom());
        verify(etudiantJpaRepository).findByPrenom("prenom");
        verifyNoMoreInteractions(etudiantJpaRepository);
    }

    @Test
    public void getAllEtudiants_WithNomAndPrenom() {
        EtudiantSearchCriteria etudiantSearchCriteria = new EtudiantSearchCriteria();
        etudiantSearchCriteria.setNom("nom");
        etudiantSearchCriteria.setPrenom("prenom");
        List<EtudiantDto> etudiantDtos = etudiantService.getAllEtudiants(etudiantSearchCriteria);
        assertEquals(1, etudiantDtos.size());
        assertEquals(Integer.valueOf(1), etudiantDtos.get(0).getId());
        assertEquals("nom", etudiantDtos.get(0).getNom());
        assertEquals("prenom", etudiantDtos.get(0).getPrenom());
        verify(etudiantJpaRepository).trouverParNomEtPrenom("nom", "prenom");
        verifyNoMoreInteractions(etudiantJpaRepository);
    }


    @Test
    public void getEtudiantById() {
        EtudiantDto etudiantDto = etudiantService.getEtudiantById(1);
        assertEquals(Integer.valueOf(1), etudiantDto.getId());
        assertEquals("nom", etudiantDto.getNom());
        assertEquals("prenom", etudiantDto.getPrenom());
        verify(etudiantJpaRepository).findById(1);
        verifyNoMoreInteractions(etudiantJpaRepository);
    }

    @Test
    public void saveEtudiant() {
        EtudiantDto etudiantDto = etudiantService.saveEtudiant(createEtudiantDto());
        assertEquals(Integer.valueOf(1), etudiantDto.getId());
        assertEquals("nom", etudiantDto.getNom());
        assertEquals("prenom", etudiantDto.getPrenom());
        verify(etudiantJpaRepository).save(any(Etudiant.class));
        verifyNoMoreInteractions(etudiantJpaRepository);
    }

    private EtudiantDto createEtudiantDto() {
        EtudiantDto etudiantDto = new EtudiantDto();
        etudiantDto.setId(1);
        etudiantDto.setNom("nom");
        etudiantDto.setPrenom("prenom");
        return etudiantDto;
    }

    @Test
    public void deleteEtudiant() {
        etudiantService.deleteEtudiant(1);
        verify(etudiantJpaRepository).deleteById(1);
    }

    @Test
    public void updateEtudiant() {
        EtudiantDto etudiantDto = etudiantService.updateEtudiant(1, createEtudiantDto());
        assertEquals(Integer.valueOf(1), etudiantDto.getId());
        assertEquals("nom", etudiantDto.getNom());
        assertEquals("prenom", etudiantDto.getPrenom());
        verify(etudiantJpaRepository).save(any(Etudiant.class));
        verifyNoMoreInteractions(etudiantJpaRepository);
    }

    @Test
    public void sortEtudiants() {
        EtudiantDto etudiantDtoId1 = new EtudiantDto();
        etudiantDtoId1.setId(1);
        EtudiantDto etudiantDtoId2 = new EtudiantDto();
        etudiantDtoId2.setId(2);
        List<EtudiantDto> etudiantDtos = etudiantService.sortEtudiants(List.of(etudiantDtoId2,etudiantDtoId1));
        assertEquals(Integer.valueOf(1),etudiantDtos.get(0).getId());
        assertEquals(Integer.valueOf(2),etudiantDtos.get(1).getId());
    }
}