package com.dao;

import com.model.User;

public interface IUser {
    
	public int addUser(User u);
	public int addUser(String nom, String log, String pass, String role);
	public User Authentification(String log,String pass);
	
	
}
