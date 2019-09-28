package com.olehpodolin.universitycli.bootstrap;

import com.olehpodolin.universitycli.domain.Degree;
import com.olehpodolin.universitycli.domain.Department;
import com.olehpodolin.universitycli.domain.Lector;
import com.olehpodolin.universitycli.repositories.DepartmentRepository;
import com.olehpodolin.universitycli.repositories.LectorRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private DepartmentRepository departmentRepository;
    private LectorRepository lectorRepository;

    public Bootstrap(DepartmentRepository departmentRepository, LectorRepository lectorRepository) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(departmentRepository.count() == 0L && lectorRepository.count() == 0L) {
            initData();
        }

    }

    private void initData() {

        Lector oleksandr = new Lector();
        oleksandr.setFirstAndLastName("Oleksandr Sandoma");
        oleksandr.setDegree(Degree.PROFESSOR);
        oleksandr.setSalary(25345.99);
        lectorRepository.save(oleksandr);


        Lector ivan = new Lector();
        ivan.setFirstAndLastName("Ivan Petrenko");
        ivan.setDegree(Degree.ASSOCIATE_PROFESSOR);
        ivan.setSalary(20543.53);
        lectorRepository.save(ivan);


        Lector ostap = new Lector();
        ostap.setFirstAndLastName("Ostap Kostantynov");
        ostap.setDegree(Degree.ASSISTANT);
        ostap.setSalary(16356.00);
        lectorRepository.save(ostap);

        Lector petro = new Lector();
        petro.setFirstAndLastName("Petro Ivanov");
        petro.setDegree(Degree.PROFESSOR);
        petro.setSalary(32000.00);
        lectorRepository.save(petro);


        Lector vadym = new Lector();
        vadym.setFirstAndLastName("Vadym Dmytrenko");
        vadym.setDegree(Degree.ASSISTANT);
        vadym.setSalary(16442.64);
        lectorRepository.save(vadym);

        Lector ihor = new Lector();
        ihor.setFirstAndLastName("Ihor Mykh");
        ihor.setDegree(Degree.ASSOCIATE_PROFESSOR);
        ihor.setSalary(23753.53);
        lectorRepository.save(ihor);


        Department chemistry = new Department();
        chemistry.setName("Chemistry");
        chemistry.setHead(oleksandr);
        chemistry.addLector(petro).addLector(vadym).addLector(ihor);

        Department accounting = new Department();
        accounting.setName("Accounting");
        accounting.setHead(ivan);
        accounting.addLector(oleksandr).addLector(ivan).addLector(ostap);

        Department advertising = new Department();
        advertising.setName("Advertising");
        advertising.setHead(ostap);
        advertising.addLector(ihor).addLector(ostap).addLector(petro).addLector(ivan);

        Department biology = new Department();
        biology.setName("Biology");
        biology.setHead(petro);
        biology.addLector(oleksandr).addLector(ihor).addLector(vadym);

        Department psychology = new Department();
        psychology.setName("Psychology");
        psychology.setHead(vadym);
        psychology.addLector(vadym).addLector(ostap).addLector(oleksandr);

        departmentRepository.save(chemistry);
        departmentRepository.save(accounting);
        departmentRepository.save(advertising);
        departmentRepository.save(biology);
        departmentRepository.save(psychology);

    }
}
