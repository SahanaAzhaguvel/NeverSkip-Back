package com.neverskip.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neverskip.model.Login;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@PostMapping
	public boolean login(@RequestBody Login login) {
		return login.getUsername().equals("admin") &&
				login.getPassword().equals("admin123");
	}

}
