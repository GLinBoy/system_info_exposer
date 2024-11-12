package com.glinboy.exposer.web.rest;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1/environment", "/api/v1/env"})
public class EnvironmentResource {

	@GetMapping("/variable")
	public ResponseEntity<Map<String, String>> getEnvironmentVariables() {
		return ResponseEntity.ok(System.getenv());
	}
}
