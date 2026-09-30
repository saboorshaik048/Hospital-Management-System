package com.codegnan.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.codegnan.entity.User;
import com.codegnan.repo.UserRepository;
import com.codegnan.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
			PasswordEncoder passwordEncoder, JwtService jwtService) {

		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}
	@PostMapping("/register")
	public String register(@RequestBody User user) {

	    if (userRepository.findByUsername(user.getUsername()).isPresent()) {
	        return "Username already exists";
	    }

	    user.setPassword(passwordEncoder.encode(user.getPassword()));

	    userRepository.save(user);

	    return "User registered successfully";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		String token = jwtService.generateToken(username);

		return token;
	}
}