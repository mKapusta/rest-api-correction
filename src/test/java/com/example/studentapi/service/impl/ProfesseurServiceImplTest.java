package com.example.studentapi.service.impl;

import com.example.studentapi.dto.ProfesseurDto;
import com.example.studentapi.dto.ProfesseurSearchCriteria;
import com.example.studentapi.entity.Professeur;
import com.example.studentapi.repository.ProfesseurJdbcRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfesseurServiceImplTest {

    @Mock
    private ProfesseurJdbcRepository professeurJdbcRepository;

    @InjectMocks
    private ProfesseurServiceImpl professeurService;

    @Before
    public void setUp() throws Exception {
        when(professeurJdbcRepository.getProfesseurById(1)).thenReturn(createProfesseur());
        when(professeurJdbcRepository.saveProfesseur(any(Professeur.class))).thenReturn(1);
        when(professeurJdbcRepository.searchProfesseurs(anyString(), anyString())).thenReturn(List.of(createProfesseur()));
    }

    private Professeur createProfesseur() {
        Professeur professeur = new Professeur();
        professeur.setId(1);
        professeur.setNom("nom");
        professeur.setPrenom("prenom");
        return professeur;
    }

    @Test
    public void searchProfesseurs() {
        ProfesseurSearchCriteria professeurSearchCriteria = new ProfesseurSearchCriteria();
        professeurSearchCriteria.setNom("nom");
        professeurSearchCriteria.setPrenom("prenom");
        List<ProfesseurDto> profs = professeurService.searchProfesseurs(professeurSearchCriteria);
        assertEquals(1, profs.size());
        assertEquals(Integer.valueOf(1), profs.get(0).getId());
        assertEquals("nom", profs.get(0).getNom());
        assertEquals("prenom", profs.get(0).getPrenom());

        verify(professeurJdbcRepository).searchProfesseurs("nom", "prenom");
        verifyNoMoreInteractions(professeurJdbcRepository);
    }

    @Test
    public void getProfesseurById() {
        ProfesseurDto professeurDto = professeurService.getProfesseurById(1);
        assertEquals(Integer.valueOf(1), professeurDto.getId());
        assertEquals("nom", professeurDto.getNom());
        assertEquals("prenom", professeurDto.getPrenom());

        verify(professeurJdbcRepository).getProfesseurById(1);
        verifyNoMoreInteractions(professeurJdbcRepository);
    }

    @Test
    public void saveProfesseur() {
        ProfesseurDto professeurDtoSaved = professeurService.saveProfesseur(new ProfesseurDto());
        assertEquals(Integer.valueOf(1), professeurDtoSaved.getId());
        verify(professeurJdbcRepository).saveProfesseur(any(Professeur.class));
        verifyZeroInteractions(professeurJdbcRepository);
    }

    @Test
    public void deleteProfesseurById() {
        professeurService.deleteProfesseurById(1);
        verify(professeurJdbcRepository).deleteProfesseurById(1);
    }

    @Test
    public void updateProfesseur() {
        professeurService.updateProfesseur(1, new ProfesseurDto());
        verify(professeurJdbcRepository).updateProfesseur(any(Professeur.class));
        verifyZeroInteractions(professeurJdbcRepository);
    }
}