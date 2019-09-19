package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Cours;
import com.example.studentapi.repository.CoursJdbcRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.test.properties")
public class CoursRepositoryImplTest {

    @Autowired
    private CoursJdbcRepository coursRepository;

    @Test
    public void getCoursWithProfesseurs() {
        Cours cours = coursRepository.getCoursWithProfesseur(1);
        assertEquals(Integer.valueOf(1), cours.getId());
        assertEquals("Clapton", cours.getProfesseur().getNom());
        assertEquals("Eric", cours.getProfesseur().getPrenom());
    }

}