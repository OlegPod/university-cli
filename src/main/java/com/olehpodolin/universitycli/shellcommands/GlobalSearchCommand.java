package com.olehpodolin.universitycli.shellcommands;

import com.olehpodolin.universitycli.shell.TemplateMatcher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class GlobalSearchCommand {

    private TemplateMatcher templateMatcher;

    public GlobalSearchCommand(TemplateMatcher templateMatcher) {
        this.templateMatcher = templateMatcher;
    }

    @ShellMethod(value = "Global search by template", key = "Global search by")
    public String globalSearch(@ShellOption({"--template"}) String template) {
        return String.format("Global matches by template %s : %s", template, templateMatcher.searchByTemplate(template));
    }
}

