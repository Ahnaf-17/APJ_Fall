package com.repository;

import com.domain.Admin;
import com.domain.Catagory;
import com.domain.Sector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SectormplRepository implements SectorRepository{
//        private SessionFactory sessionFactory;
//    public SectormplRepository(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//    public List<Catagory> getAll() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Catagory> adminQuery = session.createQuery("from Catagory ", Catagory.class);
//        return catagoryQuery.getResultList();
//    }
//    public Sector create(Sector sector) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(sector);
//        return sector;
//    }
private SessionFactory sessionFactory;

    public SectormplRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Sector> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Sector> sectoradminQuery = session.createQuery("from Sector ", Sector.class);
        return sectorQuery.getResultList();
    }

    public Sector create(Sector Sector) {
        Session session = sessionFactory.getCurrentSession();
        session.save(Sector);
        return Sector;
    }




}
