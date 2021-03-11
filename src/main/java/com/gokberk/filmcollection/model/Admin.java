package com.gokberk.filmcollection.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	public Admin() {}
	
	public Admin(String userName,String firstName,String lastName,String password) {
		super(userName,firstName,lastName,password);
	}
	
	public Admin(String userName){
		super(userName);
	}
}
