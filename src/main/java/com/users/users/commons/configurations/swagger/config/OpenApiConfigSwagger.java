package com.users.users.commons.configurations.swagger.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigSwagger {

    @Bean
    public OpenAPI userServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Service API")
                        .description("Microservicio de gestión de usuarios: registro, consulta por email y documento.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo de Usuarios")
                                .email("soporte-usuarios@usuarios.com")
                                .url("https://usuarios.com/usuarios"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación completa de la plataforma Usuarios")
                        .url("https://usuarios.com/docs"));
    }
}
