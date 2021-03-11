package com.gokberk.filmcollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokberk.filmcollection.model.Admin;
import com.gokberk.filmcollection.model.StandardUser;
import com.gokberk.filmcollection.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public void addStdUser(@RequestBody StandardUser user) {
		System.out.println("api requested");
		userService.addStdUser(user);
	}
	
	@PostMapping("/admin")
	public void addAdmin(@RequestBody Admin user) {
		userService.addAdmin(user);
	}
	
}
