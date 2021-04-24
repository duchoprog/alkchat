package com.ducho.alkchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ducho.alkchat.User;
import com.ducho.alkchat.UserRepository;

@Controller
public class AppController {
	@Autowired
	private UserRepository userRepo;
	@GetMapping("")
	public String viewHome(){
		return "index";
	}
	@GetMapping("/register")
	public String viewRegister(Model model){
		model.addAttribute("user", new User());
		return "register";
	}
	
	/*
	 * @PostMapping("/process_reg") public String processReg(User user) {
	 * userRepo.save(user); return "culo";}
	 */
@PostMapping("/process_reg")
public String processRegister(User user) {
	
	userRepo.save(user);
	
	return "reg_success";
}



}


