package com.tahanebti.bitoftnops.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes(BASIC_AUTH_SECURITY_SCHEME,
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                		.title(applicationName)
                		.description("User service auth")
                		.version("1.0")
                		.contact(new Contact()
                				.name("Taha Nebti")
                				.email("taha.nebti@gmail.com")
                				)
                		);
    }

    public static final String BASIC_AUTH_SECURITY_SCHEME = "basicAuth";
}