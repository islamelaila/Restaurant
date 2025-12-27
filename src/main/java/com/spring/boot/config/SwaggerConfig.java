package com.spring.boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = " Restaurant Endpoints",
                description = "This is a Restaurant Endpoint API",
                contact = @Contact (
                        name = " islam El-aila",
                        email = "islamelaila8@gmail.com",
                        url = "https://www.linkedin.com/in/islam-el-aila-4a0a4b276/"
                ),
                license = @License(
                        name = "R1 license",
                        url = "http://localhost:4200"

                ),
                version = "1.0.0"
        )
)
public class SwaggerConfig {
}
