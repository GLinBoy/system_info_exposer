package com.glinboy.exposer.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter {

	@Value("${application.api.token-name:X-API-KEY}")
	private String tokenName;

	@Value("${application.api.token-value:123XYZ}")
	private String tokenValue;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		extractToken(request)
		.ifPresentOrElse(t -> {
				if (t.equals(tokenValue)) {
					SecurityContextHolder.getContext()
					.setAuthentication(new ApiKeyAuthentication(tokenValue, AuthorityUtils.NO_AUTHORITIES));
				} else {
					throw new BadCredentialsException("Invalid API Key");
				}
			}, () -> new BadCredentialsException("Invalid API Key"));
		filterChain.doFilter(request, response);
	}
	
	private Optional<String> extractToken(HttpServletRequest request) {
		return Optional
				.ofNullable(request.getHeader(tokenName));
	}

}
