package com.example.studentapi.repository.impl;

import com.example.studentapi.entity.Adresse;
import com.example.studentapi.repository.AdresseHibernateRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AdresseHibernateRepositoryImpl implements AdresseHibernateRepository {

    @Autowired
    private EntityManager entityManager;

    private Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Adresse getAdresseById(Integer id) {
        String hql = "FROM Adresse a where a.id = :id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        return (Adresse) query.uniqueResult();
    }

    @Override
    public List<Adresse> getFurthestAdresse() {
        return null;
    }

    @Override
    public void saveAdresse(Adresse adresse) {
        getCurrentSession().persist(adresse);
    }

    @Override
    public void deleteAdresseById(Integer id) {
        String hql = "DELETE FROM Adresse a where a.id = :id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateAdresse(Integer id, Adresse adresse) {
        String hql = "UPDATE Adresse a set a.distance= :distance, a.ville = :ville where a.id = :id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("ville", adresse.getVille());
        query.setParameter("distance", adresse.getDistance());
        query.setParameter("id", id);
        query.executeUpdate();

    }

    @Override
    public List<Adresse> getAllAdresses() {
        String hql = "FROM Adresse";
        Query query = getCurrentSession().createQuery(hql);
        return (List<Adresse>) query.list();
    }
}
