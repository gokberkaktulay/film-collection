package com.gokberk.filmcollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.gokberk.filmcollection.dto.StdUserDTO;
import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.service.FilmService;

@Controller()
public class WebController {
	
	@Autowired
	private FilmService filmService;

	
	private static final String URL_PREFIX = "http://localhost:8080";
	
	@RequestMapping(value= {"/","home","index"})
    public String viewHomePage() {
        return "index";
    }
	
	@RequestMapping("/register")
	public String registration(Model model) {
		return "register";
	}
	
	@RequestMapping("/films")
	public String showFilms(Model model) {
		//WebClient client = WebClient.create(URL_PREFIX);
		//List<Film> films = client.get().uri("/api/films").retrieve().bodyToFlux(Film.class);
		model.addAttribute("films",filmService.getAllFilms());
		return "films";
	}
	
	@PostMapping("/register-submit")
	public String registrationSubmit(StdUserDTO user) {
		WebClient client = WebClient.create(URL_PREFIX);
		client.post().uri("/api/user").bodyValue(user).retrieve().bodyToMono(String.class).block();
		System.out.println("api responded");
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		return "login";
	}
	
	@GetMapping("/editFilm/{id}")
	public String filmEditForm(@PathVariable long id, Model model) {
		Film film = filmService.findFilm(id);
		model.addAttribute("film",film);
		System.out.println("Film id cont: " + film.getId());
		return "editFilm";
	}
	
	@PostMapping("/editFilm/{id}")
	public String filmEdit(Film film) {
		System.out.println("edit id: " + film.getId());
		WebClient client = WebClient.create(URL_PREFIX);
		client.put().uri("/api/films").bodyValue(film).retrieve().bodyToMono(String.class).block();
		return "redirect:/films";
	}
	
	/*@RequestMapping(value="/seedstartermng", params={"addRow"})
	public String addRow(final SeedStarter seedStarter, BindingResult bindingResult) {
	    seedStarter.getRows().add(new Row());
	    return "seedstartermng";
	}

	@RequestMapping(value="/seedstartermng", params={"removeRow"})
	public String removeRow(
	        final SeedStarter seedStarter, final BindingResult bindingResult, 
	        final HttpServletRequest req) {
	    final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
	    seedStarter.getRows().remove(rowId.intValue());
	    return "seedstartermng";
	}*/
}
