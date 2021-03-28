package com.gokberk.filmcollection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gokberk.filmcollection.model.Actor;
import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public Page<Film> getAllFilms(@RequestParam int page){
		Pageable paging = PageRequest.of(page,2);
		return filmService.getAllFilms(paging);
	}
	
	@PostMapping
	public void addFilm(@RequestBody Film film) {
		filmService.addFilm(film);
	}
	
	@PutMapping
	public void updateFilm(@RequestBody Film film) {
		filmService.updateFilm(film);
	}

	@DeleteMapping
	public void removeFilm(@RequestBody long id) {
		filmService.removeFilm(id);
	}
	
	@PostMapping("/actor/{id}")
	public void addActors(@PathVariable("id") long id,@RequestBody List<Actor> actors) {
		filmService.addActors(id,actors);
	}
	
	@DeleteMapping("/actor/{id}")
	public void removeActor(@PathVariable("id") long id,@RequestBody Actor actor) {
		filmService.removeActor(id, actor);
	}
	
	@PutMapping("/language/{id}")
	public void addLanguages(@PathVariable("id") long id,@RequestBody List<String> languages) {
		filmService.addLanguage(id,languages);
	}
	
	@DeleteMapping("/language/{id}")
	public void removeLanguage(@PathVariable("id") long id,@RequestBody String language) {
		filmService.removeLanguage(id, language);
	}
}
