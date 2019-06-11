package com.example.studentapi.repository;

import com.example.studentapi.entity.Responsable;

import java.util.List;

public interface ResponsableHibernateRepository {

    Responsable getResponsableById(Integer id);

    List<Responsable> getResponsableOfAnEtudiant();

    void saveResponsable(Responsable responsable);

    void deleteResposableById(Integer id);

    void updateResponsable(Integer Id, Responsable responsable);

    List<Responsable> getAllResponsables();
}
