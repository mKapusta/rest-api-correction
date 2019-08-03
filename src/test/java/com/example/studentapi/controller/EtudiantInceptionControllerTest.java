package com.example.studentapi.controller;

import com.example.studentapi.dto.EtudiantDto;
import com.example.studentapi.service.EtudiantInceptionService;
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
public class EtudiantInceptionControllerTest {

    @InjectMocks
    private EtudiantInceptionController etudiantInceptionController;
    @Mock
    private EtudiantInceptionService etudiantInceptionService;
    private EtudiantDto etudiantDto;

    @Before
    public void setUp() throws Exception {
        etudiantDto = new EtudiantDto();
        when(etudiantInceptionService.getAllEtudiants()).thenReturn(List.of(etudiantDto));
        when(etudiantInceptionService.getEtudiantById(anyInt())).thenReturn(etudiantDto);
    }

    @Test
    public void getAllEtudiants() {
        assertEquals(List.of(etudiantDto),etudiantInceptionController.getAllEtudiants());
        verify(etudiantInceptionService).getAllEtudiants();
        verifyNoMoreInteractions(etudiantInceptionService);
    }

    @Test
    public void getEtudiantById() {
        assertEquals(etudiantDto,etudiantInceptionController.getEtudiantById(1));
        verify(etudiantInceptionService).getEtudiantById(1);
        verifyNoMoreInteractions(etudiantInceptionService);
    }
}