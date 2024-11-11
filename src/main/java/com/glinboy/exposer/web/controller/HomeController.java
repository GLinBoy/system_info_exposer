package com.glinboy.exposer.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@Value("${spring.application.name}")
	private String applicationName;

	@GetMapping
	public ResponseEntity<Map<String, String>> getHome() {
		return ResponseEntity.ok(Map.of("status", "OK", "application", applicationName));
	}
}
