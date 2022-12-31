package com.repository;

import com.domain.Admin;
import com.domain.Catagory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CatagorymplRepository implements CatagoryRepository{
    private SessionFactory sessionFactory;

    public CatagoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public List<Catagory> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Catagory> catagoryQuery = session.createQuery("from Catagory ", Catagory.class);
        return catagoryQuery.getResultList();
    }

    public Catagory create(Catagory catagory) {
        Session session = sessionFactory.getCurrentSession();
        session.save(catagory);
        return catagory;
    }

    public Catagory get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Catagory.class, id);
    }

    public Catagory update(Catagory catagory) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(catagory);
        return catagory;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Catagory catagory = get(id);
        if (catagory != null) {
            session.delete(catagory);
        }
    }
}
