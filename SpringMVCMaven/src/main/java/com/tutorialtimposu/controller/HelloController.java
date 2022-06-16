package com.tutorialtimposu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("name", "Ucup");
        return "hello";
    }
}
