package com.olehpodolin.universitycli.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class UniversityPromptProvider implements PromptProvider {


    @Override
    public AttributedString getPrompt() {
        return new AttributedString("University:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
    }
}
