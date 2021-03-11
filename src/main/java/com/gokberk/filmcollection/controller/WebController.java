package com.gokberk.filmcollection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.gokberk.filmcollection.dto.StdUserDTO;

@Controller()
public class WebController {
	@GetMapping(value= {"/","home","index"})
    public String viewHomePage() {
        return "index";
    }
	
	@GetMapping("/register")
	public String registration(Model model) {
		return "register";
	}
	
	@GetMapping("/films")
	public String showFilms() {
		return "films";
	}
	
	@PostMapping("/register-submit")
	public String registrationSubmit(StdUserDTO user) {
		WebClient client = WebClient.create("http://localhost:8080");
		client.post().uri("/api/user").bodyValue(user).retrieve().bodyToMono(String.class).block();
		System.out.println("api responded");
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		return "login";
	}
	
	@PostMapping("/login-submit")
	public String loginSubmit() {
		return "films";
	}
}
