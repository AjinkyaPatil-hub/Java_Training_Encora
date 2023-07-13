package com.encora.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EntryController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable ("name") String name) {
		return "!!Hello "+name+" how are you!!";
	}
}
