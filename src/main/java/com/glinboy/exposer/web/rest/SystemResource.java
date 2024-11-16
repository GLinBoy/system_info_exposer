package com.glinboy.exposer.web.rest;

import java.util.Properties;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1/system", "/api/v1/sys"})
public class SystemResource {
	
	@GetMapping("/properties")
	public ResponseEntity<Properties> getProperties() {
		return ResponseEntity.ok(System.getProperties());
	}

}
