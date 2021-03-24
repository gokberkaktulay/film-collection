package com.gokberk.filmcollection.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ActorPK implements Serializable {
	private String name;
	private long film;
	
	public String getFirstName() {
		return name;
	}
	public void setFirstName(String firstName) {
		this.name = firstName;
	}
	public long getFilm() {
		return film;
	}
	public void setFilm(long film) {
		this.film = film;
	}
}
