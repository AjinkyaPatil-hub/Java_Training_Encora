package com.encora.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Cookies {

	@GetMapping("/cookies")
	public List<String> showcookies(){
		List<String> cookieList = Arrays.asList("first_cookie","inproper_cookie","get_list");
		return cookieList;
	}
}


