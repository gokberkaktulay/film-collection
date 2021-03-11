package com.gokberk.filmcollection.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ActorPK implements Serializable {
	private String firstName;
	private String lastName;
	private long film;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getFilm() {
		return film;
	}
	public void setFilm(long film) {
		this.film = film;
	}
}
