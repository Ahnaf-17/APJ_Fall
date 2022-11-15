package com.service;

import com.domain.Employee;
import com.domain.LeaveType;
import com.repository.EmployeeRepository;
import com.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class TypeService {
    private LeaveRepository leaveRepository;

    public TypeService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Transactional
    public boolean insert(LeaveType leaveType) throws SQLException {
        leaveType.setId(leaveType.getId());
        return leaveRepository.create(leaveType);
    }
}
