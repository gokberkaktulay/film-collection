package com.gokberk.filmcollection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.gokberk.filmcollection.model.Admin;
import com.gokberk.filmcollection.model.StandardUser;
import com.gokberk.filmcollection.model.User;



@Component
public class Startup implements ApplicationRunner {
	
	@Autowired
	private com.gokberk.filmcollection.service.UserService userService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("API call");
		WebClient client = WebClient.create("http://localhost:8080");
		String response = client.get().uri("/api/films").retrieve().bodyToMono(String.class).block();
		System.out.println(response);
		
		User a = new StandardUser("a");
		StandardUser b = new StandardUser("b");
		Admin admin = new Admin("admin");
		
		userService.addStdUser(((StandardUser)a));
		userService.addStdUser(b);
		userService.addAdmin(admin);
		
		//List<? extends User> users = userService.getAllStandardUsers();
		
	}
}
