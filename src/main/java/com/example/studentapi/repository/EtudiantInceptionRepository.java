package com.example.studentapi.repository;

import com.example.studentapi.entity.Etudiant;

import java.util.List;

public interface EtudiantInceptionRepository {

    List<Etudiant> getAllStudents();

    Etudiant getStudentById(Integer id);
}
