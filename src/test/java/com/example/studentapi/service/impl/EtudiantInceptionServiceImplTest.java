package com.example.studentapi.service.impl;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.repository.EtudiantInceptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EtudiantInceptionServiceImplTest {

    @InjectMocks
    private EtudiantInceptionServiceImpl etudiantInceptionService;

    @Mock
    private EtudiantInceptionRepository etudiantInceptionRepository;

    @Before
    public void setUp() throws Exception {
        when(etudiantInceptionRepository.getAllStudents()).thenReturn(List.of(createEtudiant()));
        when(etudiantInceptionRepository.getStudentById(anyInt())).thenReturn(createEtudiant());
    }

    private Etudiant createEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        etudiant.setNom("nom");
        etudiant.setPrenom("prenom");
        return etudiant;
    }

    @Test
    public void getAllEtudiants() {
        List<EtudiantDto> etudiantDtos = etudiantInceptionService.getAllEtudiants();
        assertEquals(1, etudiantDtos.size());
        assertEquals(Integer.valueOf(1), etudiantDtos.get(0).getId());
        assertEquals("nom", etudiantDtos.get(0).getNom());
        assertEquals("prenom", etudiantDtos.get(0).getPrenom());
        verify(etudiantInceptionRepository).getAllStudents();
        verifyNoMoreInteractions(etudiantInceptionRepository);

    }

    @Test
    public void getEtudiantById() {
        EtudiantDto etudiantDto = etudiantInceptionService.getEtudiantById(1);
        assertEquals(Integer.valueOf(1), etudiantDto.getId());
        assertEquals("nom", etudiantDto.getNom());
        assertEquals("prenom", etudiantDto.getPrenom());
        verify(etudiantInceptionRepository).getStudentById(1);
        verifyNoMoreInteractions(etudiantInceptionRepository);
    }
}