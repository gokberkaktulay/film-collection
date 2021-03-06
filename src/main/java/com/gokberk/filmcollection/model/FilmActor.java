/*
 * Relationship table between film and actor tables. Holds the role attribute
 */
//package com.gokberk.filmcollection.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Embeddable;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.Table;
//
//
//@SuppressWarnings("serial")
//@Entity
//@Table(name="filmactor")
//public class FilmActor implements Serializable {
//	
//	@Embeddable
//	private class FilmActorPK implements Serializable{
//		
//		private String filmTitle;
//		private int actorId;
//	}
//	
//	@EmbeddedId
//	private FilmActorPK pk;
//	
//	@ManyToOne
//	@MapsId("filmTitle")
//	@JoinColumn(name="film_title")
//	private Film film;
//	
//	@ManyToOne
//	@MapsId("actorId")
//	@JoinColumn(name="actor_id")
//	private Actor actor;
//	
//	private String role;
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public Film getFilm() {
//		return film;
//	}
//
//	public Actor getActor() {
//		return actor;
//	}
//	
//}
