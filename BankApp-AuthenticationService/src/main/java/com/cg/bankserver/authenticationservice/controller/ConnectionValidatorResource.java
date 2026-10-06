package com.cg.bankserver.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankserver.authenticationservice.entities.ConnValidationResponse;
import com.cg.bankserver.authenticationservice.entities.User;
import com.cg.bankserver.authenticationservice.exceptions.UsernameAlreadyExistsException;
import com.cg.bankserver.authenticationservice.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConnectionValidatorResource {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public ResponseEntity<String> helloRoute() {
		return ResponseEntity.ok("World");
	}

	@PostMapping(value = { "/check" })
	public ResponseEntity<String> check() {
		return ResponseEntity.ok("Checked");
	}

	@PostMapping(value = { "/add" })
	public ResponseEntity<User> addUser(@RequestBody User user) throws UsernameAlreadyExistsException {
		return ResponseEntity.ok(userService.encryptAndSave(user));
	}

	@PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConnValidationResponse> validatePost() {
		return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.POST.name())
				.isAuthenticated(true).build());
	}

	@GetMapping(value = "/validate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConnValidationResponse> validateGet(HttpServletRequest request) {
		String username = (String) request.getAttribute("username");
		String token = (String) request.getAttribute("jwt");
		log.info("username " + username);
		List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) request.getAttribute("authorities");
		return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.GET.name())
				.username(username).token(token).authorities(grantedAuthorities).isAuthenticated(true).build());
	}

	@PostMapping(value = "/whitelisted", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConnValidationResponse> validateWhitelistedPost() {
		return ResponseEntity
				.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.POST.name()).build());
	}

	@GetMapping(value = "/whitelisted", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConnValidationResponse> validateWhitelistedGet(HttpServletRequest request) {
		String username = (String) request.getAttribute("username");
		return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.GET.name())
				.username(username).build());
	}

}