package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Produit;
import com.mysql.jdbc.ResultSet;
import com.util.DBInteraction;

public class ProduitDao implements IProduit {

	@Override
	public int addProduit(Produit p) {
		DBInteraction.connect();
		int rs = DBInteraction.MAJ("insert into produit  values(null,'"+p.getDesignation()+"',"+p.getPrix()+","+p.getQuantite()+",'"+p.getDescription()+"')");
		DBInteraction.Disconnect();
		return rs;
	}

	@Override
	public int addProduit(String designation, double prix, int quantite, String description) {
		DBInteraction.connect();
		int rs = DBInteraction.MAJ("insert into produit  values(null,'"+designation+"',"+prix+","+quantite+",'"+description+"')");
		DBInteraction.Disconnect();
		return rs;
	}

	@Override
	public int delete(int id) {
		DBInteraction.connect();
		int rs = DBInteraction.MAJ("delete from produit where id = "+id);
		DBInteraction.Disconnect();
		return rs;
	}

	@Override
	public Produit findProduitById(int id){
		Produit p = null ;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from produit where id = "+id);
		try {
			if(rs.next()) {
				p = new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBInteraction.Disconnect();
		return p;
	}

	@Override
	public List<Produit> allProduit() {
		List<Produit> produits = new ArrayList<Produit>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from produit");
		try {
			while(rs.next()) {
				Produit p = new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
				produits.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBInteraction.Disconnect();
		return produits;
	}

	@Override
	public int update(int id, Produit p) {
		DBInteraction.connect();
		int rs = DBInteraction.MAJ("update produit  set designation='"+p.getDesignation()+"', prix="+p.getPrix()+",quantite="+p.getQuantite()+",description='"+p.getDescription()+"' where id= "+id);
		DBInteraction.Disconnect();
		return rs;
	}

}
