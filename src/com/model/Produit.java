package com.model;

public class Produit {
    
	private int id;
    private String designation;
    private double prix;
    private int quantite;
    private String description;
   
	public Produit() {
		super();
		
	}
	
	public Produit(int id, String designation, double prix, int quantite, String description) {
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
	}
	
	public Produit(String designation, double prix, int quantite, String description) {
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
	
}
