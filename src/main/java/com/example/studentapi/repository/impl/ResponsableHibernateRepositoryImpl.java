package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Etudiant;
import com.example.studentapi.entity.Responsable;
import com.example.studentapi.repository.ResponsableHibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ResponsableHibernateRepositoryImpl implements ResponsableHibernateRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Responsable getResponsableById(Integer id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Responsable> criteria = builder
                .createQuery(Responsable.class);
        Root<Responsable> root = criteria.from(Responsable.class);
        criteria.where(builder.equal(root.get("id"), id));
        ;
        return entityManager.createQuery(criteria).getSingleResult();

    }

    @Override
    public List<Responsable> getResponsableOfAnEtudiant(Integer idEtudiant) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Responsable> criteria = builder
                .createQuery(Responsable.class);
        Root<Etudiant> root = criteria.from(Etudiant.class);
        criteria.select(root.get("responsables")).where(builder.equal(root.get("id"), idEtudiant));
        ;
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public void saveResponsable(Responsable responsable) {
        entityManager.persist(responsable);
    }

    @Override
    public void deleteResposableById(Integer id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Responsable> criteria = builder.createCriteriaDelete(
                Responsable.class);
        Root<Responsable> root = criteria.from(Responsable.class);
        criteria.where(builder.equal(root.get("id"), id));
        entityManager.createQuery(criteria).executeUpdate();

    }

    @Override
    public void updateResponsable(Integer Id, Responsable responsable) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Responsable> criteria = builder.createCriteriaUpdate(
                Responsable.class);
        Root<Responsable> root = criteria.from(Responsable.class);
        criteria.set(root.get("nom"), responsable.getNom())
                .set(root.get("prenom"), responsable.getPrenom())
                .where(builder.equal(root.get("id"), responsable.getId()));
        entityManager.createQuery(criteria).executeUpdate();
    }

    @Override
    public List<Responsable> getAllResponsables() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Responsable> criteria = builder
                .createQuery(Responsable.class);
        criteria.from(Responsable.class);
        return entityManager.createQuery(criteria).getResultList();
    }
}
