package com.gokberk.filmcollection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.service.FilmService;

@RestController
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/films")
	public List<Film> getAllFilms(){
		return filmService.getAllFilms();
	}
	
	@PostMapping("/films")
	public void addFilm(@RequestBody Film film) {
		System.out.println("Film:" + film.title);
		System.out.println("Controller level add");
		filmService.AddFilm(film);
	}
	
}
