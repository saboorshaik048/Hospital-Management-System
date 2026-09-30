package com.codegnan.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Service
public class JwtService {

	private final SecretKey secretKey = Keys
			.hmacShaKeyFor("my-super-secret-key-for-jwt-authentication-123456".getBytes());

	// Generate JWT
	public String generateToken(String username) {

		return Jwts.builder().subject(username).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).signWith(secretKey).compact();
	}

	// Extract username from JWT
	public String extractUsername(String token) {

		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
	}

	// Validate JWT
	public boolean validateToken(String token) {

		try {
			Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);

			return true;

		} catch (Exception e) {
			return false;
		}
	}
}