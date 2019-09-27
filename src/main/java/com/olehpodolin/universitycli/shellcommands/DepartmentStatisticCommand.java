package com.olehpodolin.universitycli.shellcommands;

import com.olehpodolin.universitycli.services.DepartmentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class DepartmentStatisticCommand {

    private DepartmentService departmentService;

    public DepartmentStatisticCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ShellMethod("Show department statistic")
    public String showDepartmentNameStatistic(@ShellOption({"--departmentName"}) String departmentName) {
        return String.format(
                "Assistants - %d" + "\n" + "Associate professors - %d" + "\n" + "Professors - %d",
                departmentService.getAssistantsCount(), departmentService.getAssociateProfessorsCount(),
                                            departmentService.getProfessorsCount());
    }
}

/*
2.Show {department_name} statistic.
        Answer: assistans - {assistams_count}.
        associate professors - {associate_professors_count}
        professors -{professors_count}
*/

