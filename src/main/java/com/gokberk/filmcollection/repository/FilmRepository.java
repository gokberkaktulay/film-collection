package com.gokberk.filmcollection.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gokberk.filmcollection.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
	Page<Film> findAll(Pageable paging);
	
	@Query(value = "SELECT f FROM Film f WHERE lower(f.title) LIKE lower(concat('%', :filter,'%'))"
			+ " OR lower(f.genre) LIKE lower(concat('%', :filter,'%'))"
			+ " OR f.id IN (SELECT a.film FROM Actor a WHERE lower(a.name) LIKE lower(concat('%', :filter,'%')))")
	Page<Film> filterFilms(String filter, Pageable paging);
}
