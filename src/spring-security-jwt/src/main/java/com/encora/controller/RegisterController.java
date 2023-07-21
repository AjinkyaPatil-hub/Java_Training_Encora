package com.encora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encora.model.UserDTO;
import com.encora.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
 	return ResponseEntity.ok(	registerService.saveOrUpdateUser(userDTO));
	}
}
