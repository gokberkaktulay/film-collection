package com.gokberk.filmcollection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.gokberk.filmcollection.model.Admin;
import com.gokberk.filmcollection.model.User;
import com.gokberk.filmcollection.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserTest {
	
	@Autowired
	private UserRepository userRepository;
	//@Autowired
	//private UserService userService;

	@Test
	void test() {
		Admin admin = new Admin("c");
		userRepository.save(admin);
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		userRepository.findAll().forEach(user ->{
			System.out.println("User " + user.getFirstName());
		});
		assertFalse(users.isEmpty());
	}

}
