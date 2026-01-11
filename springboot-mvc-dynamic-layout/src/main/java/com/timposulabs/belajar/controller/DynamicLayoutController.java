package com.timposulabs.belajar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DynamicLayoutController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("content", "home :: home_content");
		return "layout";
	}
	
	@GetMapping("/service")
	public String service(Model model) {
		model.addAttribute("content", "service :: service_content");
		return "layout";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("content", "contact :: contact_content");
		return "layout";
	}
}
