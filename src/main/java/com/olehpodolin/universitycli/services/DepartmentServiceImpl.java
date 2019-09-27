package com.olehpodolin.universitycli.services;

import com.olehpodolin.universitycli.domain.Lector;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public Lector getHeadOfDepartment(String departmentName) {
        return null;
    }

    @Override
    public Double getAverageSalary(String departmentName) {
        return null;
    }

    @Override
    public Integer getTotalEmployee() {
        return null;
    }

    @Override
    public Integer getAssistantsCount() {
        return null;
    }

    @Override
    public Integer getAssociateProfessorsCount() {
        return null;
    }

    @Override
    public Integer getProfessorsCount() {
        return null;
    }
}
