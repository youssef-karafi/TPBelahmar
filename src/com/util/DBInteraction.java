package com.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DBInteraction {
	
	private static Connection con;
	private static Statement stat;
	private static String URL ="jdbc:mysql://localhost/tpbelahmar";
	
	
	
	public static void connect() {
		
		try {
			// chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// etablissement de connection 
			con = (Connection) DriverManager.getConnection(URL,"root","");
			// creation du statement
			stat = (Statement) con.createStatement();
		} catch (ClassNotFoundException | SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int MAJ(String sql) {
		int nb =0;
		try {
			nb = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nb;
	}
	
	public static ResultSet Select(String sql) {
		ResultSet rs = null;
		try {
			rs = (ResultSet) stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static void Disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
