package com.service;

import com.domain.Application;
import com.domain.Employee;
import com.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class ApplicationService {
    private ApplicationRepository ApplicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.ApplicationRepository = applicationRepository;
    }

    @org.springframework.transaction.annotation.Transactional
    public boolean insert(Application application) throws SQLException {
//        application.getFromdate(application.getFromdate());
        application.setReason(application.getReason());
        return ApplicationRepository.create(application.getId_of_employee());
    }
}
