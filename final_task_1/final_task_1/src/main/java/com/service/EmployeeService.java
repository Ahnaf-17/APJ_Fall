package com.service;

import com.domain.Employee;
import com.domain.Student;
import com.repository.EmployeeRepository;
import com.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @org.springframework.transaction.annotation.Transactional
    public boolean insert(Employee employee) throws SQLException {
        employee.setFirstname(employee.getFirstname().toUpperCase());
        employee.setLastname(employee.getLastname().toUpperCase());
        return employeeRepository.create(employee);
    }
}
