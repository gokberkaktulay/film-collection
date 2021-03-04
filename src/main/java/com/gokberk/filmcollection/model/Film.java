package com.gokberk.filmcollection.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "Title")
	public String title;
	
	@Column(name = "Year")
	private Date year;
	
	@Column(name = "Genre")
	private String genre;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Medium")
	private String medium;
	
	public Film() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
//	public Film(String title, Date year, String genre, String description, String medium) {
//		this.title = title;
//		this.year = year;
//		this.genre = genre;
//		this.description = description;
//		this.medium = medium;
//	}
	
}
