package com.example.studentapi.controller;

import com.example.studentapi.dto.MatiereDto;
import com.example.studentapi.service.MatiereService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MatiereControllerTest {

    @InjectMocks
    private MatiereController matiereController;

    @Mock
    private MatiereService matiereService;

    private MatiereDto matiereDto;

    @Before
    public void setUp() throws Exception {
        matiereDto = new MatiereDto();
        when(matiereService.getAllMatieres()).thenReturn(List.of(matiereDto));
    }

    @Test
    public void getAllMatiere() {
        assertEquals(List.of(matiereDto), matiereController.getAllMatiere());
        verify(matiereService).getAllMatieres();
        verifyNoMoreInteractions(matiereService);
    }
}