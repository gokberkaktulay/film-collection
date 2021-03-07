package com.gokberk.filmcollection.repository;

import org.springframework.data.repository.CrudRepository;

import com.gokberk.filmcollection.model.StandardUser;

public interface StandardUserRepository extends CrudRepository<StandardUser, Integer> {

}
