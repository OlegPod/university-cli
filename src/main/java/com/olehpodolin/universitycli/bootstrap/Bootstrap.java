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


        Lector ivan = new Lector();
        ivan.setFirstAndLastName("Ivan Petrenko");
        ivan.setDegree(Degree.ASSOCIATE_PROFESSOR);
        ivan.setSalary(20543.53);


        Lector ostap = new Lector();
        ostap.setFirstAndLastName("Ostap Kostantynov");
        ostap.setDegree(Degree.ASSISTANT);
        ostap.setSalary(16356.00);


        Lector petro = new Lector();
        petro.setFirstAndLastName("Petro Ivanov");
        petro.setDegree(Degree.PROFESSOR);
        petro.setSalary(32000.00);


        Lector vadym = new Lector();
        vadym.setFirstAndLastName("Vadym Dmytrenko");
        vadym.setDegree(Degree.ASSISTANT);
        vadym.setSalary(16442.64);


        Lector ihor = new Lector();
        ihor.setFirstAndLastName("Ihor Mykh");
        ihor.setDegree(Degree.ASSOCIATE_PROFESSOR);
        ihor.setSalary(23753.53);


        Department computerScience = new Department();
        computerScience.setName("Computer Science");
        computerScience.setHead(petro);
        computerScience.addLector(petro).addLector(vadym).addLector(ihor);

        Department accounting = new Department();
        accounting.setName("Accounting");
        accounting.setHead(oleksandr);
        accounting.addLector(oleksandr).addLector(ivan).addLector(ostap);

        Department advertising = new Department();
        advertising.setName("Advertising");
        advertising.setHead(ihor);
        advertising.addLector(ihor).addLector(ostap).addLector(petro);

        Department aerospaceStudies = new Department();
        aerospaceStudies.setName("Aerospace Studies");
        aerospaceStudies.setHead(oleksandr);
        aerospaceStudies.addLector(oleksandr).addLector(ihor).addLector(vadym);

        Department biologicalSciences = new Department();
        biologicalSciences.setName("Biological Sciences");
        biologicalSciences.setHead(vadym);
        biologicalSciences.addLector(vadym).addLector(ostap).addLector(oleksandr);

        departmentRepository.save(computerScience);
        departmentRepository.save(accounting);
        departmentRepository.save(advertising);
        departmentRepository.save(aerospaceStudies);
        departmentRepository.save(biologicalSciences);




    }
}
