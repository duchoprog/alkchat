package com.ducho.alkchat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ducho.alkchat.User;

@Controller
public class AppController {
	@GetMapping("")
	public String viewHome(){
		return "index";
	}
	@GetMapping("/register")
	public String viewRegister(Model model){
		model.addAttribute("user", new User());
		return "register";
	}

}
