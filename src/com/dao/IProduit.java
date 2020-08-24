package com.dao;

import java.util.List;

import com.model.Produit;

public interface IProduit {
    
	public int addProduit(Produit p);
    public int addProduit(String designation, double prix, int quantite, String description);
    public int delete(int id);
    public int update(int id, Produit p);
    public Produit findProduitById(int id);
    public List<Produit> allProduit();
	
}
