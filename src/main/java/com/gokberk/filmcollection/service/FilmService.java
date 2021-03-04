package com.gokberk.filmcollection.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	private FilmRepository filmRepository;
	
	public List<Film> getAllFilms(){
		List<Film> films = new ArrayList<Film>();
		filmRepository.findAll().forEach(films::add);
		return films;
	}
	
	public void AddFilm(Film film) {
		System.out.println("Service level add");
		filmRepository.save(film);
	}
}
