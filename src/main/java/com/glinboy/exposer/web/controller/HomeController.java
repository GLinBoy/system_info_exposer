package com.glinboy.exposer.web.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public void getHome(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
}
