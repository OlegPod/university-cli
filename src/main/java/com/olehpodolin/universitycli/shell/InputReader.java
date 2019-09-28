package com.olehpodolin.universitycli.shell;

import com.olehpodolin.universitycli.domain.Department;
import com.olehpodolin.universitycli.repositories.DepartmentRepository;
import org.springframework.shell.standard.ShellComponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ShellComponent
public class InputReader{

    private DepartmentRepository departmentRepository;

    public InputReader(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public String getDepartmentFromInput(String input) {
        List<String> inputList = Arrays.asList(input.split(","));

        List<Department> departmentList = departmentRepository.findAll();
        List<String> departmentNamesList = new ArrayList<>();
        departmentList.forEach(department -> departmentNamesList.add(department.getName()));

        String[] patternArray = new String[]{"Who", "is", "head", "of", "department", "Show", "statistic",
                "the", "average", "salary", "for", "count", "employee", "Global", "search", "by"};
        List<String> commandsPattern = Arrays.asList(patternArray);

        List<String> subList = new ArrayList<>(inputList);

        subList.removeAll(commandsPattern);
        StringBuilder returnName = new StringBuilder();
        subList.forEach(s -> returnName.append(s));

        return returnName.toString();
    }
}
