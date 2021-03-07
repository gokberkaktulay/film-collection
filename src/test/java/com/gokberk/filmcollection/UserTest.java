package com.gokberk.filmcollection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gokberk.filmcollection.model.Admin;
import com.gokberk.filmcollection.model.User;
import com.gokberk.filmcollection.repository.UserRepository;

@SpringBootTest
class UserTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void test() {
		Admin admin = new Admin();
		admin.setFirstName("a");
		admin.setLastName("b");
		userRepository.save(admin);
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		assertFalse(users.isEmpty());
	}

}
