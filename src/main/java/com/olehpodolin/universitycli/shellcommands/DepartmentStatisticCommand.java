package com.olehpodolin.universitycli.shellcommands;

import com.olehpodolin.universitycli.services.DepartmentService;
import com.olehpodolin.universitycli.shell.InputReader;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class DepartmentStatisticCommand {

    private DepartmentService departmentService;

    private InputReader inputReader;

    public DepartmentStatisticCommand(DepartmentService departmentService, InputReader inputReader) {
        this.departmentService = departmentService;
        this.inputReader = inputReader;
    }

    @ShellMethod(value = "Show department statistic", key = "Show")
    public String showDepartmentNameStatistic(@ShellOption(arity = 2) String input) {

        String departmentName = inputReader.getDepartmentFromInput(input);

        return String.format(
                "Assistants - %d" + "\n" + "Associate professors - %d" + "\n" + "Professors - %d",
                departmentService.getAssistantsCount(departmentName), departmentService.getAssociateProfessorsCount(departmentName),
                departmentService.getProfessorsCount(departmentName));
    }
}

