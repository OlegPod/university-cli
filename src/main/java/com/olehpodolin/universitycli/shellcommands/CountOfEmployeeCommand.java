package com.olehpodolin.universitycli.shellcommands;

import com.olehpodolin.universitycli.services.DepartmentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class CountOfEmployeeCommand {

    private DepartmentService departmentService;

    public CountOfEmployeeCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ShellMethod(value = "Displaying count of employee for department",
            key = "Show count of employee for")
    public String showCountOfEmployee(@ShellOption({"--departmentName"}) String departmentName) {
        return String.format("Total amount of employee in %s are %d peoples",
                                            departmentName, departmentService.getTotalEmployee(departmentName));
    }
}
