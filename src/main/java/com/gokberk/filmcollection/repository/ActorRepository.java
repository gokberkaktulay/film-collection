package com.gokberk.filmcollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gokberk.filmcollection.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	@Transactional
	void deleteByNameAndFilm_Id(String name,long filmId);

}
