package com.olehpodolin.universitycli.services;

public interface DepartmentService {

    String getHeadOfDepartment(String departmentName);
    Double getAverageSalary(String departmentName);
    Integer getTotalEmployee(String departmentName);
    Long getAssistantsCount(String departmentName);
    Long getAssociateProfessorsCount(String departmentName);
    Long getProfessorsCount(String departmentName);
}
