package com.project.controller;

//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.service.RestService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class HomeController {

	private RestService service;
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public void home(Model model) {
		model.addAttribute("category", service.getCodeList());
	}
}
