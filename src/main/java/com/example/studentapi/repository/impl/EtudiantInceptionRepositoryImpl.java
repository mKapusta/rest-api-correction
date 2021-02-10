package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.repository.EtudiantInceptionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EtudiantInceptionRepositoryImpl implements EtudiantInceptionRepository {

    @Value("${inception.url}")
    private String inceptionUrl;

    @Override
    public List<Etudiant> getAllStudents() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Etudiant>> response
                = restTemplate.exchange(inceptionUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Etudiant>>() {});
        return response.getBody();



        //

    }

    @Override
    public Etudiant getStudentById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Etudiant> response
                = restTemplate.getForEntity(inceptionUrl + id, Etudiant.class);
        return response.getBody();
    }
}
