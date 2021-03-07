package com.gokberk.filmcollection.repository;

import org.springframework.data.repository.CrudRepository;

import com.gokberk.filmcollection.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
