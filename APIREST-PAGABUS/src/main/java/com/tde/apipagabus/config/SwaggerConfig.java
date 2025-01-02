package com.tde.apipagabus.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de PagaBus")
                        .version("1.0.0")
                        .description("Documentación de la API REST de PagaBus")
                        .termsOfService("https://example.com/terms")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Equipo de Soporte")
                                .email("soporte@pagabus.com")
                                .url("https://pagabus.com")))
                .servers(Arrays.asList(
                        new Server().url("https://api.pagabus.com").description("Servidor de Producción"),
                        new Server().url("http://localhost:8080").description("Servidor de Desarrollo")
                ));
    }
}
