package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.service.RestService;

@Controller
public class HomeController {
	private RestService service;
	
	@GetMapping("/")
	public void home(Model model) {
		model.addAttribute("category", service.getCodeList());
	}
}
