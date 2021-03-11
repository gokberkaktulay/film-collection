package com.gokberk.filmcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gokberk.filmcollection.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
