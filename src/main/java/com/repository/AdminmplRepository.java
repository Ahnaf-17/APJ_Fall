package com.repository;

import com.domain.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdminmplRepository implements AdminRepository{
    private SessionFactory sessionFactory;

    public AdminmplRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Admin> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Admin> adminQuery = session.createQuery("from Admin ", Admin.class);
        return adminQuery.getResultList();
    }

    public Admin create(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.save(admin);
        return admin;
    }

    public Admin get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Admin.class, id);
    }

    public Admin update(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(admin);
        return admin;
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Admin admin = get(id);
        if (admin != null) {
            session.delete(admin);
        }
    }
}
