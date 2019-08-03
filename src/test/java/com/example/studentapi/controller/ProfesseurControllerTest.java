package com.example.studentapi.controller;

import com.example.studentapi.dto.ProfesseurDto;
import com.example.studentapi.dto.ProfesseurSearchCriteria;
import com.example.studentapi.service.ProfesseurService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProfesseurControllerTest {

    @InjectMocks
    private ProfesseurController professeurController;
    @Mock
    private ProfesseurService professeurService;
    private ProfesseurDto professeurDto;

    @Before
    public void setUp() throws Exception {
        professeurDto = new ProfesseurDto();
        when(professeurService.saveProfesseur(professeurDto)).thenReturn(professeurDto);
        when(professeurService.updateProfesseur(1, professeurDto)).thenReturn(professeurDto);
        when(professeurService.getProfesseurById(anyInt())).thenReturn(professeurDto);
        when(professeurService.searchProfesseurs(any(ProfesseurSearchCriteria.class))).thenReturn(List.of(professeurDto));
        doNothing().when(professeurService).deleteProfesseurById(anyInt());
    }

    @Test
    public void getAllProfesseurs() {
        ProfesseurSearchCriteria professeurSearchCriteria = new ProfesseurSearchCriteria();
        assertEquals(List.of(professeurDto), professeurController.getAllProfesseurs(professeurSearchCriteria));
        verify(professeurService).searchProfesseurs(professeurSearchCriteria);
        verifyNoMoreInteractions(professeurService);
    }

    @Test
    public void getProfesseurById() {
        assertEquals(professeurDto, professeurController.getProfesseurById(1));
        verify(professeurService).getProfesseurById(1);
        verifyNoMoreInteractions(professeurService);
    }

    @Test
    public void saveProfesseur() {
        assertEquals(professeurDto, professeurController.saveProfesseur(professeurDto));
        verify(professeurService).saveProfesseur(professeurDto);
        verifyNoMoreInteractions(professeurService);
    }

    @Test
    public void deleteProfesseurById() {
        professeurController.deleteProfesseurById(1);
        verify(professeurService).deleteProfesseurById(1);
        verifyNoMoreInteractions(professeurService);
    }

    @Test
    public void updateProfesseur() {
        assertEquals(professeurDto, professeurController.updateProfesseur(1, professeurDto));
        verify(professeurService).updateProfesseur(1, professeurDto);
        verifyNoMoreInteractions(professeurService);

    }
}