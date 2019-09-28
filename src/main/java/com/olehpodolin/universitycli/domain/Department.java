package com.olehpodolin.universitycli.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "department_lector",
                        joinColumns = @JoinColumn(name = "department_id"),
                        inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private Set<Lector> lectors = new LinkedHashSet<>();

    @OneToOne
    private Lector head;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }

    public Department addLector(Lector lector) {
        this.lectors.add(lector);
        lector.getDepartments().add(this);
        return this;
    }

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getLectors().equals(that.getLectors()) &&
                getHead().equals(that.getHead());
    }
}
