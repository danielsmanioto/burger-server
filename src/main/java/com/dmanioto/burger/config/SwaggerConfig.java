package com.dmanioto.burger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI burgerServerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("burger-server")
                        .description("API burger-server")
                        .version("API V.1-001")
                        .contact(new Contact()
                                .name("Daniel Augusto Smanioto")
                                .url("www.danielsmanioto.com")
                                .email("daniel.smanioto@gmail.com")));
    }

}
