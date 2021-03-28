package com.gokberk.filmcollection.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gokberk.filmcollection.model.Actor;
import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.repository.ActorRepository;
import com.gokberk.filmcollection.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ActorRepository actorRepository;
	
	// return a list of all films
	public Page<Film> getAllFilms(Pageable paging){
		Page<Film> films = filmRepository.findAll(paging);
		return films;
	}
	
	// return a filtered list
	public Page<Film> filterFilms(String filter, Pageable paging){
		Page<Film> films = filmRepository.filterFilms(filter, paging);
		return films;
	}
	
	// insert a new Film entity
	public void addFilm(Film film) {
		if(!filmRepository.existsById(film.getId()))	// do nothing if a film by same title exists
			filmRepository.save(film);
	}
	
	// update fields of a film
	public void updateFilm(Film filmUpdates) {

		try {
			Film film = filmRepository.findById(filmUpdates.getId()).get();// throws exception if record does not exist
			if (filmUpdates.getTitle() != null)
				film.setTitle(filmUpdates.getTitle());
			if (filmUpdates.getDescription()!=null)
				film.setDescription(filmUpdates.getDescription());
			if (filmUpdates.getGenre()!=null)
				film.setGenre(filmUpdates.getGenre());
			if (filmUpdates.getMedium()!=null)
				film.setMedium(filmUpdates.getMedium());
			if (filmUpdates.getYear()!=null)
				film.setYear(filmUpdates.getYear());
			filmRepository.save(film);
				
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}

	// remove a film
	public void removeFilm(long id) {
		try {
			Film film = filmRepository.findById(id).get();// throws exception if record does not exist
			filmRepository.delete(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void addActors(long id,List<Actor> actors) {
		try {
			Film film = filmRepository.findById(id).get();// throws exception if record does not exist
			// if a film-actor value exists, do not add it again
			actors.forEach(actor -> {
				actor.setFilm(film);
				actorRepository.save(actor);
			});
			
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void removeActor(long id,Actor actor) {
		try {
			Film film = filmRepository.findById(id).get();// throws exception if record does not exist
			actor.setFilm(film);
			actorRepository.deleteByNameAndFilm_Id(actor.getName(),id);
			
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void addLanguage(long id,List<String> languages) {
		try {
			Film film = filmRepository.findById(id).get();// throws exception if record does not exist
			List<String> filmLanguages = film.getLanguages();
			// if a film-actor value exists, do not add it again
			languages.forEach(language -> {
				if(!filmLanguages.contains(language))
					filmLanguages.add(language);		
			});
			filmRepository.save(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void removeLanguage(long id,String language) {
		try {
			Film film = filmRepository.findById(id).get();// throws exception if record does not exist
			if(film.getLanguages().remove(language))
				filmRepository.save(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public Film findFilm(long id) {
		Film film = filmRepository.findById(id).orElseThrow();
		return film;
	}
}
