package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Responsable;
import com.example.studentapi.repository.ResponsableHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResponsableHibernateRepositoryImpl implements ResponsableHibernateRepository {
    @Override
    public Responsable getResponsableById(Integer id) {
        return null;
    }

    @Override
    public List<Responsable> getResponsableOfAnEtudiant() {
        return null;
    }

    @Override
    public void saveResponsable(Responsable responsable) {

    }

    @Override
    public void deleteResposableById(Integer id) {

    }

    @Override
    public void updateResponsable(Integer Id, Responsable responsable) {

    }

    @Override
    public List<Responsable> getAllResponsables() {
        return null;
    }
}
