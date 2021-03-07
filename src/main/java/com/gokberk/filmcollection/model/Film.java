package com.gokberk.filmcollection.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Film {

	@Id
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Year")
	private Date year;
	
	@Column(name = "Genre")
	private String genre;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Medium")
	private String medium;
	
	@OneToMany(mappedBy = "film",cascade = CascadeType.ALL)
	private Set<Actor> actors;
	
	@ElementCollection
	@CollectionTable(uniqueConstraints = {@UniqueConstraint(columnNames={"film_title","languages"})})
	private List<String> languages;
	
	public Film() {}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Film film = (Film) o;
        boolean result;
        result = this.getTitle() == film.getTitle();
        return result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
		
}
