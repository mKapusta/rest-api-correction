package com.example.studentapi.service.impl;

import com.example.studentapi.dto.MatiereDto;
import com.example.studentapi.entity.Matiere;
import com.example.studentapi.repository.MatiereJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MatiereServiceImplTest {

    @InjectMocks
    private MatiereServiceImpl matiereService;
    @Mock
    private MatiereJpaRepository matiereJpaRepository;

    @Test
    public void getAllMatieres() {
        Matiere matiere = new Matiere();
        matiere.setId(1);
        matiere.setNom("test");

        when(matiereJpaRepository.findAll()).thenReturn(List.of(matiere));
        List<MatiereDto> matiereDtos = matiereService.getAllMatieres();
        assertEquals(1,matiereDtos.size());
        assertEquals(Integer.valueOf(1),matiereDtos.get(0).getId());
        assertEquals("test",matiereDtos.get(0).getNom());

        verify(matiereJpaRepository).findAll();
        verifyNoMoreInteractions(matiereJpaRepository);
    }

}