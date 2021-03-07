package com.gokberk.filmcollection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gokberk.filmcollection.model.Actor;
import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.service.FilmService;

@RestController
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/films")
	public List<Film> getAllFilms(){
		System.out.println("get films");
		return filmService.getAllFilms();
	}
	
	@PostMapping("/films")
	public void addFilm(@RequestBody Film film) {
		filmService.addFilm(film);
	}
	
	@PutMapping("films/update")
	public void updateFilm(@RequestBody Film film) {
		filmService.updateFilm(film);
	}

	@DeleteMapping("/films")
	public void removeFilm(@RequestBody String title) {
		filmService.removeFilm(title);
	}
	
	@PostMapping("/films/actor/{title}")
	public void addActors(@PathVariable("title") String title,@RequestBody List<Actor> actors) {
		filmService.addActors(title,actors);
	}
	
	@DeleteMapping("/films/actor/{title}")
	public void removeActor(@PathVariable("title") String title,@RequestBody Actor actor) {
		filmService.removeActor(title, actor);
	}
	
	@PutMapping("/films/language/{title}")
	public void addLanguages(@PathVariable("title") String title,@RequestBody List<String> languages) {
		filmService.addLanguage(title,languages);
	}
	
	@DeleteMapping("/films/language/{title}")
	public void removeLanguage(@PathVariable("title") String title,@RequestBody String language) {
		filmService.removeLanguage(title, language);
	}
}
