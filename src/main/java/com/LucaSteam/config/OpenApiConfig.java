package com.LucaSteam.config;

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
        		  .info(new Info().title("Game API")
        	                .description("Student API Documentation")
        	                .version("v1.0")
        	                .contact(new Contact().name("Grupo 3 LucaSteam").
        	                        url("https://lucasteamgrupo3.es").email("grupo3@lucasteam.es"))
        	                .license(new License().name("LICENSE").url("http://springdoc.org")))
        	                .externalDocs(new ExternalDocumentation()
        	                .description("Proyect description")
        	                .url("https://myproyect.es"));
    }
	

}
