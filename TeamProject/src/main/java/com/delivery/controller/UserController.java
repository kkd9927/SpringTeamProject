package com.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.delivery.domain.UserDTO;
import com.delivery.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
//@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	
	@GetMapping("/register")
	public String register() {
		return "user/register";
	}
	
	@PostMapping("register")
	public String register(UserDTO user) {
		service.register(user);
		
		return "redirect:/";
	}
}