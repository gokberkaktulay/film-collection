package com.gokberk.filmcollection;


import java.net.MalformedURLException;

import javax.annotation.PostConstruct;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;



@Component
public class Startup implements ApplicationRunner {
	
	@PostConstruct
	private void init() throws MalformedURLException {
		System.out.println("Init complete");
		
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("API call");
		WebClient client = WebClient.create("http://localhost:8080");
		String response = client.get().uri("/films").retrieve().bodyToMono(String.class).block();
		System.out.println(response);
	}
}
