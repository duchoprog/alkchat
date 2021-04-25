package com.ducho.alkchat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@PostMapping("/process_reg")
	public String processRegister(User user) {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String encodedPass=encoder.encode(user.getPassword());
		user.setPassword(encodedPass);

		userRepo.save(user);

		return "reg_success";
	}
	@GetMapping("/list_users")
	public String viewUsers(Model model){
		List <User> listUsers=userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "list_users";
	}



}


