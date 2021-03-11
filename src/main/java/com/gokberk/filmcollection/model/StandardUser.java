package com.gokberk.filmcollection.model;

import javax.persistence.Entity;

@Entity
public class StandardUser extends User {
	
	public StandardUser() {}
	
	public StandardUser(String userName,String firstName,String lastName,String password) {
		super(userName,firstName,lastName,password);
	}
	
	public StandardUser(String userName){
		super(userName);
	}

}
