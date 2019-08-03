package com.example.studentapi.controller;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.dto.EtudiantSearchCriteria;
import com.example.studentapi.service.EtudiantService;
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
public class EtudiantControllerTest {

    @InjectMocks
    private EtudiantController etudiantController;
    @Mock
    private EtudiantService etudiantService;
    private EtudiantDto etudiantDto;

    @Before
    public void setUp() throws Exception {
        etudiantDto = new EtudiantDto();
        when(etudiantService.getEtudiantById(Integer.valueOf(1))).thenReturn(etudiantDto);
        when(etudiantService.getAllEtudiants(any(EtudiantSearchCriteria.class))).thenReturn(List.of(etudiantDto));
        when(etudiantService.saveEtudiant(any(EtudiantDto.class))).thenReturn(etudiantDto);
        when(etudiantService.updateEtudiant(anyInt(), any(EtudiantDto.class))).thenReturn(etudiantDto);
        doNothing().when(etudiantService).deleteEtudiant(anyInt());

    }

    @Test
    public void getAllEtudiants() {
        EtudiantSearchCriteria etudiantSearchCriteria = new EtudiantSearchCriteria();
        assertEquals(List.of(etudiantDto), etudiantController.getAllEtudiants(etudiantSearchCriteria));
        verify(etudiantService).getAllEtudiants(etudiantSearchCriteria);
        verifyNoMoreInteractions(etudiantService);
    }

    @Test
    public void getEtudiantById() {
        assertEquals(etudiantDto, etudiantController.getEtudiantById(Integer.valueOf(1)));
        verify(etudiantService).getEtudiantById(Integer.valueOf(1));
        verifyNoMoreInteractions(etudiantService);
    }

    @Test
    public void saveEtudiant() {
        assertEquals(etudiantDto, etudiantController.saveEtudiant(etudiantDto));
        verify(etudiantService).saveEtudiant(etudiantDto);
        verifyNoMoreInteractions(etudiantService);
    }

    @Test
    public void deleteEtudiantById() {
        etudiantController.deleteEtudiantById(Integer.valueOf(1));
        verify(etudiantService).deleteEtudiant(Integer.valueOf(1));
    }

    @Test
    public void updateEtudiant() {
        assertEquals(etudiantDto, etudiantController.updateEtudiant(Integer.valueOf(1), etudiantDto));
        verify(etudiantService).updateEtudiant(Integer.valueOf(1), etudiantDto);
        verifyNoMoreInteractions(etudiantService);
    }
}