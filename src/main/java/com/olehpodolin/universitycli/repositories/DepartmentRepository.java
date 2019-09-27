package com.olehpodolin.universitycli.repositories;

import com.olehpodolin.universitycli.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
