package com.encora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public")
public class PublicController {

	
	@GetMapping("/home")
	public String sayHello() {
		return "!!Hello this is  home page How are you!!";
	}
}
