package com.gokberk.filmcollection.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired
	private FilmRepository filmRepository;
	
	// return a list of all films
	public List<Film> getAllFilms(){
		List<Film> films = new ArrayList<Film>();
		filmRepository.findAll().forEach(films::add);
		return films;
	}
	
	// insert a new Film entity
	public void addFilm(Film film) {
		if(!filmRepository.existsById(film.getTitle()))	// do nothing if a film by same title exists
			filmRepository.save(film);
	}
	
	// update fields of a film
	public void updateFilm(Film filmUpdates) {
		if (filmUpdates.getTitle()!=null) {
			try {
				Film film = filmRepository.findById(filmUpdates.getTitle()).get();// throws exception if record does not exist
				
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
	}

	// remove a film
	public void removeFilm(String title) {
		try {
			Film film = filmRepository.findById(title).get();// throws exception if record does not exist
			filmRepository.delete(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void addActors(String title,List<String> actors) {
		try {
			Film film = filmRepository.findById(title).get();// throws exception if record does not exist
			List<String> filmActors = film.getActors();
			// if a film-actor value exists, do not add it again
			actors.forEach(actor -> {
				if(!filmActors.contains(actor))
					filmActors.add(actor);		
			});
			filmRepository.save(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void removeActor(String title,String actor) {
		try {
			Film film = filmRepository.findById(title).get();// throws exception if record does not exist
			if(film.getActors().remove(actor))
				filmRepository.save(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
	
	public void addLanguage(String title,List<String> languages) {
		try {
			Film film = filmRepository.findById(title).get();// throws exception if record does not exist
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
	
	public void removeLanguage(String title,String language) {
		try {
			Film film = filmRepository.findById(title).get();// throws exception if record does not exist
			if(film.getLanguages().remove(language))
				filmRepository.save(film);
		}
		catch(NoSuchElementException e) {
			System.err.println(e);
		}
	}
}
