package com.gokberk.filmcollection.repository;

import org.springframework.data.repository.CrudRepository;

import com.gokberk.filmcollection.model.Film;

public interface FilmRepository extends CrudRepository<Film, String> {

}
