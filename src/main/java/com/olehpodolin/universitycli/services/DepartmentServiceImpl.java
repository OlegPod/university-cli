package com.olehpodolin.universitycli.services;

import com.olehpodolin.universitycli.domain.Degree;
import com.olehpodolin.universitycli.domain.Department;
import com.olehpodolin.universitycli.domain.Lector;
import com.olehpodolin.universitycli.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadOfDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName).getHead().getFirstAndLastName();
    }

    @Override
    @Transactional
    public Double getAverageSalary(String departmentName) {
        Department foundDepartment = departmentRepository.findByName(departmentName);

        int count = foundDepartment.getLectors().size();
        double summary = 0;

        for(Lector lector : foundDepartment.getLectors())
            summary += lector.getSalary();

        return summary / count;
    }

    @Override
    @Transactional
    public Integer getTotalEmployee(String departmentName) {

        return departmentRepository.findByName(departmentName).getLectors().size();
    }

    @Override
    @Transactional
    public Long getAssistantsCount(String departmentName) {
        Department foundDepartment = departmentRepository.findByName(departmentName);

        return foundDepartment.getLectors().stream()
                .filter(lector -> lector.getDegree().equals(Degree.ASSISTANT)).count();

    }

    @Override
    @Transactional
    public Long getAssociateProfessorsCount(String departmentName) {
        Department foundDepartment = departmentRepository.findByName(departmentName);

        return foundDepartment.getLectors().stream()
                .filter(lector -> lector.getDegree().equals(Degree.ASSOCIATE_PROFESSOR)).count();
    }

    @Override
    @Transactional
    public Long getProfessorsCount(String departmentName) {
        Department foundDepartment = departmentRepository.findByName(departmentName);

        return foundDepartment.getLectors().stream()
                .filter(lector -> lector.getDegree().equals(Degree.PROFESSOR)).count();
    }
}
