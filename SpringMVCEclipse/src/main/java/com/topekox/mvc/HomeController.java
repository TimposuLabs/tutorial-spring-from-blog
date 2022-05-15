package com.topekox.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(name = "/")
	public String home(Model model) {
		
		model.addAttribute("name", "Ucup");
		return "home";
	}

}
