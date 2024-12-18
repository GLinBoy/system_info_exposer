package com.glinboy.exposer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@SecurityScheme(name = "API Key Authentication",
	type = SecuritySchemeType.APIKEY,
	in = SecuritySchemeIn.HEADER,
	paramName = "X-API-KEY")
public class OpenApiConfig {
	
	@Value("${spring.application.name}")
	private String name;
	
	@Value("${application.info.description}")
	private String description;
	
	@Value("${application.info.version}")
	private String version;
	
	@Value("${application.info.license}")
	private String license;
	
	@Value("${application.info.license-url}")
	private String licenseUrl;
	
	@Value("${application.info.github-url}")
	private String githubUrl;

	@Bean
	OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title(name)
						.description(description)
						.version(version)
						.license(new License().name(license)
								.url(licenseUrl))
						)
				.externalDocs(new ExternalDocumentation()
						.description("Source code")
						.url(githubUrl));
	}
}
