package com.gokberk.filmcollection.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gokberk.filmcollection.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
	Page<Film> findAll(Pageable paging);
}
