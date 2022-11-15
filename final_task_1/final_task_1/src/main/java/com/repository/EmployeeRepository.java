package com.repository;

import com.domain.Employee;
import com.domain.Student;
import com.service.EmployeeService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


@Repository
public class EmployeeRepository {
    private SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Employee> list() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> studentQuery = session.createQuery("from Employee",Employee.class);
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
