package com.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.domain.UserAddrVO;
import com.project.domain.UserDTO;
import com.project.service.UserAddrService;
import com.project.service.UserService;

import jdk.internal.org.jline.utils.Log;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final UserAddrService userAddrService;
	
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
			return "user/registerBusiForm";
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
	
	@GetMapping("/address")
	@ResponseBody
	public List<UserAddrVO> address(String u_id) {
		return userAddrService.getAddr(u_id);
	}
}