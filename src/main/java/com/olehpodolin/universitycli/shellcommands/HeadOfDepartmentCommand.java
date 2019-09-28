package com.olehpodolin.universitycli.shellcommands;

import com.olehpodolin.universitycli.services.DepartmentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HeadOfDepartmentCommand {

    private DepartmentService departmentService;

    public HeadOfDepartmentCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ShellMethod(value = "Displays who is the head of a department", key = "Who is head of")
    public String showHeadOfDepartment(@ShellOption({"--departmentName"}) String departmentName) {
        return String.format("Head of %s is %s",
                                            departmentName, departmentService.getHeadOfDepartment(departmentName));
    }
}
