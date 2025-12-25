package com.glinboy.exposer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.glinboy.exposer.security.TokenFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {
	
	private final TokenFilter tokenFilter;

	private static final String[] AUTH_WHITELIST = {
			"/",
			"/actuator/health/**",
			// -- Swagger UI v3 (OpenAPI)
			"/swagger-ui.html",
			"/v3/api-docs/**",
			"/swagger-ui/**"
		};

	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		return http
				.cors(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
				.authorizeHttpRequests(request -> 
					request.requestMatchers(AUTH_WHITELIST)
						.permitAll()
						.anyRequest().authenticated())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
}
