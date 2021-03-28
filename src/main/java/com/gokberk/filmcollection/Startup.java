package com.gokberk.filmcollection;


import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gokberk.filmcollection.model.Actor;
import com.gokberk.filmcollection.model.Admin;
import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.model.StandardUser;
import com.gokberk.filmcollection.model.User;
import com.gokberk.filmcollection.service.FilmService;
import com.gokberk.filmcollection.service.UserService;



@Component
public class Startup implements ApplicationRunner {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FilmService filmService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		 * Seed Users
		 */
		User a = new StandardUser("a");
		StandardUser b = new StandardUser("b");
		Admin admin = new Admin("admin");
		
		userService.addStdUser(((StandardUser)a));
		userService.addStdUser(b);
		userService.addAdmin(admin);
		
		/*
		 * Seed films
		 */
		List<Actor> actors = new ArrayList<Actor>();
		actors.add(new Actor("Actor A","**"));
		actors.add(new Actor("Actor B","***"));
		Film film = new Film();
		film.setTitle("A");
		film.setYear(Year.of(1963));
		film.setGenre("Adventure, Crime");
		film.setMedium("*");
		film.setLanguages(Arrays.asList("French"));
		film.setDescription("Some film");
		filmService.addFilm(film);
		filmService.addActors(film.getId(), actors);
		
		actors = new ArrayList<Actor>();
		actors.add(new Actor("Actor D","**"));
		actors.add(new Actor("Actor G","***"));
		film = new Film();
		film.setTitle("C");
		film.setYear(Year.of(1980));
		film.setGenre("Drama");
		film.setMedium("*");
		film.setLanguages(Arrays.asList("German"));
		film.setDescription("Some film");
		filmService.addFilm(film);
		filmService.addActors(film.getId(), actors);
		
		actors = new ArrayList<Actor>();
		actors.add(new Actor("Actor T","**"));
		film = new Film();
		film.setTitle("B");
		film.setYear(Year.of(1967));
		film.setGenre("Steampunk");
		film.setMedium("*");
		film.setLanguages(Arrays.asList("English"));
		film.setDescription("Some film");
		filmService.addFilm(film);
		filmService.addActors(film.getId(), actors);
		
		actors = new ArrayList<Actor>();
		actors.add(new Actor("Actor TF","**"));
		film = new Film();
		film.setTitle("AB");
		film.setYear(Year.of(1967));
		film.setGenre("Steampunk");
		film.setMedium("*");
		film.setLanguages(Arrays.asList("English"));
		film.setDescription("Some film");
		filmService.addFilm(film);
		filmService.addActors(film.getId(), actors);
		
		actors = new ArrayList<Actor>();
		actors.add(new Actor("Actor Dar","**"));
		actors.add(new Actor("Actor Ghtr","***"));
		film = new Film();
		film.setTitle("Cgr");
		film.setYear(Year.of(1980));
		film.setGenre("Drama");
		film.setMedium("*");
		film.setLanguages(Arrays.asList("German"));
		film.setDescription("Some film");
		filmService.addFilm(film);
		filmService.addActors(film.getId(), actors);

		
	}
}
