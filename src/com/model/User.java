package com.model;

public class User {
    private int id;
    private String nom;
    private String log;
    private String pass;
    private String role;
    
	public User() {
		super();	
	}

	public User(int id, String nom, String log, String pass, String role) {
		this.id = id;
		this.nom = nom;
		this.log = log;
		this.pass = pass;
		this.role = role;
	}
		
	public User(String nom, String log, String pass, String role) {
		this.nom = nom;
		this.log = log;
		this.pass = pass;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	 
}
