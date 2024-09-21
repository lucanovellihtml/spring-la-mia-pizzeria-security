package com.lessons.java.spring.pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//CONTROLLER DI BASE
@Controller
@RequestMapping("/")
public class PageController {

	@GetMapping("/")
	public String homePage(Model model) {
		return "/pages/homepage";
	}
	
}
