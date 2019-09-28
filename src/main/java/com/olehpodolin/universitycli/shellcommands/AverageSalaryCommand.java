package com.olehpodolin.universitycli.shellcommands;

import com.olehpodolin.universitycli.services.DepartmentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AverageSalaryCommand {

    private DepartmentService departmentService;

    public AverageSalaryCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ShellMethod(value = "Displaying average salary for department",
            key = "Show the average salary for department")
    public String showAverageSalaryForDepartment(@ShellOption({"--departmentName"}) String departmentName) {
        return String.format("The average salary of %s is %s", departmentName,
                                            departmentService.getAverageSalary(departmentName));
    }
}
