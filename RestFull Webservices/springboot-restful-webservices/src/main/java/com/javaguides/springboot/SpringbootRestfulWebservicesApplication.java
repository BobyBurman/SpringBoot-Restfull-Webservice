package com.javaguides.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication

@OpenAPIDefinition( //swagger use
		info =@Info(
				title = "SpringBoot rest api annotation documentaions",
				description = "Spring boot",
				version = "v1.3.0",
				contact = @Contact(
						name="Boby Burman",
						email="email@tcs.com",
						url="http://localhost:8080/swagger-ui/index.html"
						),
				license = @License(
						name="Apache 2.0",
						url="http://localhost:8080/v3/api-docs"
						)
				),
		externalDocs=@ExternalDocumentation(
				description = "Rest Api project",
				url = "http://localhost:8080/swagger-ui/index.html"
				)
		) 

public class SpringbootRestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
