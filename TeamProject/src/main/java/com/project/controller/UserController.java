package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.domain.UserAddrDTO;
import com.project.domain.UserDTO;
import com.project.security.CustomUser;
import com.project.security.CustomUserDetailsService;
import com.project.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final CustomUserDetailsService customUserDetailsService;
	
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
		userService.register(user);
		
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
	
	@PostMapping("/address/add")
	@ResponseBody
	public String addAddress(@RequestBody UserAddrDTO addr, @AuthenticationPrincipal CustomUser customUser, HttpSession session) {
		UserDTO user = userService.addAddr(addr);
		session.setAttribute("principal", customUserDetailsService.loadUserByUsername(user.getU_id()));
		
		return "OK";
	}
}