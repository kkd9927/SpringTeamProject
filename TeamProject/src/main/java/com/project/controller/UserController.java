package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.domain.UserDTO;
import com.project.service.UserService;

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
	
	@GetMapping("/register/form")
	public String registerForm(@ModelAttribute("u_code") int u_code) {
		return "user/registerForm";
	}
	
	@PostMapping("/register")
	public String register(UserDTO user) {
		service.register(user);
		
		if(user.getU_code() == 1) {
			return "redirect:/";
		} else {
			return "/rest/restRegister";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/login/fail")
	public String loginFailed(Model model) {
		model.addAttribute("loginError", true);
		return "user/login";
	}
}