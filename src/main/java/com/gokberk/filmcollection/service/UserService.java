package com.gokberk.filmcollection.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gokberk.filmcollection.model.Admin;
import com.gokberk.filmcollection.model.StandardUser;
import com.gokberk.filmcollection.model.User;
import com.gokberk.filmcollection.repository.AdminRepository;
import com.gokberk.filmcollection.repository.StandardUserRepository;
import com.gokberk.filmcollection.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StandardUserRepository stdRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	/*
	 * Standard User Begin
	 */
	public void addStdUser(StandardUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public List<StandardUser> getAllStandardUsers(){
		List<StandardUser> users = new ArrayList<StandardUser>();
		stdRepository.findAll().forEach(users::add);
		return users;
	}
	/*
	 * Standard User End
	 */
	
	/*
	 * Admin Begin
	 */
	public void addAdmin(Admin user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public List<Admin> getAllAdmins(){
		List<Admin> users = new ArrayList<Admin>();
		adminRepository.findAll().forEach(users::add);
		return users;
	}
	/*
	 * Admin End
	 */
	
	/*
	 * User Begin
	 */
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
}
