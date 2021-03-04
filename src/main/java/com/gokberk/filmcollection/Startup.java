package com.gokberk.filmcollection;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Startup {
	
	@PostConstruct
	private void init() {
		System.out.println("Init complete"); 
	}
}
