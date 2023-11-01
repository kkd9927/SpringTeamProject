package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.service.RestService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	
	private RestService service;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("category", service.getCodeList());
		
		return "home";
	}
}
