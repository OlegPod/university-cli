package com.olehpodolin.universitycli.shell;

import com.olehpodolin.universitycli.domain.Lector;
import com.olehpodolin.universitycli.repositories.LectorRepository;
import org.springframework.shell.standard.ShellComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ShellComponent
public class TemplateMatcher {

    private LectorRepository lectorRepository;

    public TemplateMatcher(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    public List<String> searchByTemplate(String template) {
        Pattern pattern = Pattern.compile(template);

        List<String> result = new ArrayList<>();

        List<Lector> lectorList = lectorRepository.findAll();
        for(Lector lector : lectorList) {
            Matcher matcher = pattern.matcher(lector.getFirstAndLastName());
            if (matcher.find())
                result.add(lector.getFirstAndLastName());
        }
        return result;
    }
}