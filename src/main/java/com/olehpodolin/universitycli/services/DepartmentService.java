package com.olehpodolin.universitycli.services;

import com.olehpodolin.universitycli.domain.Lector;

public interface DepartmentService {

    Lector getHeadOfDepartment(String departmentName);
    Double getAverageSalary(String departmentName);
    Integer getTotalEmployee();
    Integer getAssistantsCount();
    Integer getAssociateProfessorsCount();
    Integer getProfessorsCount();
}
