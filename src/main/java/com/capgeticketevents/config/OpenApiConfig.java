package com.capgeticketevents.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI StudentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Student API")
                .description("Documentación de la Student API")
                .version("v1.0")
                .contact(new Contact().name("Eventos").
                        url("https://grupoB.es").email("grupoB@event.es"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("microservicio event")
                .url("https://event.es"));
    }
}
