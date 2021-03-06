/*
 * Initially there was a many to many relationship between actors and films with the role attribute.
 * I decided I don't want to deal with adding and deleting actors so I am cutting out the relationship and converting
 * Actor into a weak entity
 */
package com.gokberk.filmcollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"firstName","lastName"})})
public class Actor{

	@Id
	@GeneratedValue
	private int actorId;
	
	private String firstName;
	
	private String lastName;
	
	private String role;
	
	@ManyToOne
	@JoinColumn(name="film_title")
	private Film film;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

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

	public Actor() {}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Actor actor = (Actor) o;
        boolean result;
        result = this.getFilm().getTitle().equals(actor.getFilm().getTitle());
        result = result && (this.getFirstName().equals(actor.getFirstName()));
        result = result && (this.getLastName().equals(actor.getLastName()));
        return result;
	}
	
	@Override
	public String toString(){
		String str = "ActorId: ";
		str = str + actorId + " fn: " + firstName + " ln: " + lastName + " role: " + role + "film: " + film.getTitle();
		return str;
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

}
