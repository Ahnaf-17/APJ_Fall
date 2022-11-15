package com.repository;

import com.domain.LeaveType;
import com.domain.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class LeaveRepository {
    private SessionFactory sessionFactory;

    public LeaveRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<LeaveType> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<LeaveType> studentQuery = session.createQuery("from LeaveType ", LeaveType.class);
        return studentQuery.getResultList();
    }

    public boolean create(LeaveType leaveType) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(leaveType);
        return true;
    }
//    public boolean update(Student student) throws SQLException{
//    }

    public LeaveType get(Long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LeaveType.class, id);
    }
}
