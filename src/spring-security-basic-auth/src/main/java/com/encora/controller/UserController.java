package com.encora.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("/city/{city}")
	public String sayHello(@PathVariable("city") String city) {
		return "Temp 32degree @ " + city;
	}
}
