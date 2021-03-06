package com.gokberk.filmcollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import com.gokberk.filmcollection.dto.StdUserDTO;
import com.gokberk.filmcollection.model.Film;
import com.gokberk.filmcollection.service.FilmService;

@Controller()
public class WebController {
	
	@Autowired
	private FilmService filmService;

	private static final int PAGE_SIZE = 10;
	private static final String URL_PREFIX = "http://localhost:8080";
	
	@RequestMapping(value= {"/","home","index"})
    public String viewHomePage() {
        return "index";
    }
	
	@RequestMapping("/register")
	public String registration() {
		return "register";
	}
	
	@RequestMapping("/films")
	public String showFilms(@RequestParam(defaultValue="0") int page , @RequestParam(defaultValue="0") int sort, Model model,@RequestParam(required = false) String filter) {
		Sort sortRules;
		switch(sort) {
		case 0:
			sortRules = Sort.by(Sort.Direction.ASC, "id");
			break;
		case 1:
			sortRules = Sort.by(Sort.Direction.ASC, "Year");
			break;
		case 2:
			sortRules = Sort.by(Sort.Direction.DESC, "Year");
			break;
		default:
			sortRules = Sort.by(Sort.Direction.ASC, "id");
		}
		Pageable paging = PageRequest.of(page,PAGE_SIZE,sortRules);
		Page<Film> films;
		if (filter == null)
			films = filmService.getAllFilms(paging);
		else
			films = filmService.filterFilms(filter,paging);

		if (films.getTotalPages() <= page && page > 0) {
			page = 0;
			paging = PageRequest.of(page,PAGE_SIZE,sortRules);
			films = filmService.getAllFilms(paging);
		}
		model.addAttribute("films", films);
		model.addAttribute("currentPage",page);
		model.addAttribute("sort",sort);
		model.addAttribute("filter",filter);
		return "films";
	}
	
	@PostMapping("/register-submit")
	public String registrationSubmit(StdUserDTO user) {
		WebClient client = WebClient.create(URL_PREFIX);
		client.post().uri("/api/user").bodyValue(user).retrieve().bodyToMono(String.class).block();
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		return "login";
	}
	
	@GetMapping("/addFilm")
	public String filmAddForm() {
		return "addFilm";
	}
	
	@PostMapping("/addFilm")
	public String filmAddSubmit(Film film) {
		System.out.println(film.getTitle());
		WebClient client = WebClient.create(URL_PREFIX);
		client.post().uri("/api/films").bodyValue(film).retrieve().bodyToMono(String.class).block();
		return "redirect:/films";
	}
	
	@GetMapping("/editFilm/{id}")
	public String filmEditForm(@PathVariable long id, Model model) {
		Film film = filmService.findFilm(id);
		model.addAttribute("film",film);
		return "editFilm";
	}
	
	@PostMapping("/editFilm/{id}")
	public String filmEdit(Film film) {
		WebClient client = WebClient.create(URL_PREFIX);
		client.put().uri("/api/films").bodyValue(film).retrieve().bodyToMono(String.class).block();
		return "redirect:/films";
	}
	
	@PostMapping("/deleteFilm/{id}")
	public String deleteFilm(@PathVariable long id) {
		WebClient client = WebClient.create(URL_PREFIX);
		((RequestBodySpec) client.delete().uri("/api/films")).bodyValue(Long.valueOf(id)).retrieve().bodyToMono(String.class).block();
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
