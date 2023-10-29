package com.project.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.domain.ResponseDTO;
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
	
	@GetMapping("/user/{user}")
	public String info() {
		return "user/info";
	}
	
	@GetMapping("/user/{user}/modify")
	public String modifyForm() {
		return "user/modify";
	}
	
	@PutMapping("/user/{user}/modify-nname")
	@ResponseBody
	public ResponseDTO modifyNname(@RequestBody HashMap<String, String> map) {
		userService.modifyNname(map);
		authReload();
		
		return new ResponseDTO("success", HttpStatus.OK);
	}
	
	@PutMapping("/user/{user}/modify-img")
	@ResponseBody
	public ResponseDTO modifyImg(@RequestBody HashMap<String, String> map) {
		userService.modifyImg(map);
		authReload();
		
		return new ResponseDTO("success", HttpStatus.OK);
	}
	
	@PutMapping("/user/{user}/modify-password")
	@ResponseBody
	public ResponseDTO modifyPassword(@RequestBody HashMap<String, String> map) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUser user = (CustomUser) authentication.getPrincipal();
		int result = userService.modifyPassword(map, user);
		authReload();
		
		return result == 1 ? new ResponseDTO("success", HttpStatus.OK) : new ResponseDTO("fail", HttpStatus.OK);
	}
	
	@PutMapping("/user/{user}/modify-phone")
	@ResponseBody
	public ResponseDTO modifyPhone(@RequestBody HashMap<String, String> map) {
		userService.modifyPhone(map);
		authReload();
		
		return new ResponseDTO("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/user/remove")
	@ResponseBody
	public ResponseDTO withdraw(@RequestBody HashMap<String, String> map) {
		userService.withdraw(map);
		authReload();
		
		return new ResponseDTO("success", HttpStatus.OK);
	}
	
	@PostMapping("/address/add")
	@ResponseBody
	public ResponseDTO addAddress(@RequestBody UserAddrDTO addr) {
		userService.addAddr(addr);
		authReload();
		
		return new ResponseDTO("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/address/remove")
	@ResponseBody
	public ResponseDTO removeAddress(@RequestBody UserAddrDTO addr) {
		userService.removeAddr(addr);
		authReload();
		
		return new ResponseDTO("success", HttpStatus.OK);
	}
	
	protected void authReload() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUser user = (CustomUser) authentication.getPrincipal();
	    SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(authentication, user.getUsername()));
	}
	
	protected Authentication createNewAuthentication(Authentication currentAuth, String username) {
	    CustomUser newPrincipal = (CustomUser) customUserDetailsService.loadUserByUsername(username);
	    UsernamePasswordAuthenticationToken newAuth = new UsernamePasswordAuthenticationToken(newPrincipal, currentAuth.getCredentials(), newPrincipal.getAuthorities());
	    newAuth.setDetails(currentAuth.getDetails());
	    
	    return newAuth;
	}
}