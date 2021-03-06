package com.gokberk.filmcollection.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gokberk.filmcollection.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
	@Transactional
	Actor deleteByFirstNameAndLastNameAndFilm_Title(String firstName, String lastName,String filmId);

}
