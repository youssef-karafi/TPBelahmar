package com.dao;

import java.sql.SQLException;

import com.model.User;
import com.mysql.jdbc.ResultSet;
import com.util.DBInteraction;

public class UserDao implements IUser {

	@Override
	public int addUser(User u) {
		DBInteraction.connect();
		int rs = DBInteraction.MAJ("insert into user values(null,'"+u.getNom()+"','"+u.getLog()+"','"+u.getPass()+"','"+u.getRole()+"')");
		DBInteraction.Disconnect();
		return rs;
	}

	@Override
	public int addUser(String nom, String log, String pass, String role) {
		DBInteraction.connect();
		int rs = DBInteraction.MAJ("insert into user values(null,'"+nom+"','"+log+"','"+pass+"','"+role+"')");
		DBInteraction.Disconnect();
		return rs;
	}

	@Override
	public User Authentification(String log, String pass) {
		User u = null;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from user where log ='"+log+"' and pass='"+pass+"'");
		try {
			if(rs.next()) {
			u = new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.Disconnect();
		return u;
	}

}
