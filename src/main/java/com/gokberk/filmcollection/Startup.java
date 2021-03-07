package com.gokberk.filmcollection;


import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.gokberk.filmcollection.model.StandardUser;
import com.gokberk.filmcollection.model.User;
import com.gokberk.filmcollection.repository.UserRepository;
import com.gokberk.filmcollection.service.UserService;



@Component
public class Startup implements ApplicationRunner {
	
	@Autowired
	private com.gokberk.filmcollection.service.UserService userService;
	
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
		
		User a = new StandardUser();
		a.setFirstName("a");
		a.setLastName("a");
		
		StandardUser b = new StandardUser();
		b.setFirstName("b");
		b.setLastName("b");
		
		userService.addStdUser(((StandardUser)a));
		userService.addStdUser(b);
		
		List<? extends User> users = userService.getAllStandardUsers();
		users.forEach(user -> {System.out.println(user.getFirstName());});
		
	}
}
