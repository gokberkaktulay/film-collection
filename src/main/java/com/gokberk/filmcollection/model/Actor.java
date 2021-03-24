/*
 * Initially there was a many to many relationship between actors and films with the role attribute.
 * I decided I don't want to deal with adding and deleting actors so I am cutting out the relationship and converting
 * Actor into a weak entity
 */
package com.gokberk.filmcollection.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ActorPK.class)
public class Actor{
	
	@Id
	private String name;
	
	private String role;
	
	@Id
	@ManyToOne
	@JoinColumn(name="film_id")
	private Film film;
	
	// default constructor
	public Actor() {}
	
	// constructor
	public Actor(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	@Override
	public String toString() {
		return name + " as " + role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
