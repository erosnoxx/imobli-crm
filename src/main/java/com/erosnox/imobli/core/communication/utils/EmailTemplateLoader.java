package com.erosnox.imobli.core.communication.utils;

import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

public class EmailTemplateLoader {

    public static String loadTemplate(String templateName) {
        var resource = new ClassPathResource("assets/email/" + templateName);

        try {
            return Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o template de e-mail: " + templateName, e);
        }
    }

    public static String processTemplate(String template, Map<String, String> placeholders) {
        for (var entry : placeholders.entrySet()) {
            template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return template;
    }
}
