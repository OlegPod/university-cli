package com.olehpodolin.universitycli.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstAndLastName;
    private Double salary;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments = new LinkedHashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Degree degree;

    public Long getId() {
        return id;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return getId().equals(lector.getId()) &&
                getFirstAndLastName().equals(lector.getFirstAndLastName()) &&
                getSalary().equals(lector.getSalary()) &&
                getDepartments().equals(lector.getDepartments()) &&
                getDegree() == lector.getDegree();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstAndLastName(), getSalary(), getDepartments(), getDegree());
    }
}
