package com.repository;

import com.domain.Application;
import com.domain.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ApplicationRepository {
    private SessionFactory sessionFactory;

    public ApplicationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Application> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Application> studentQuery = session.createQuery("from Application",Application.class);
        return studentQuery.getResultList();
    }

    public boolean create(Employee employee) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        return true;
    }
//    public boolean update(Student student) throws SQLException{
//    }

    public Employee get(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }
}
