package com.util;


import com.dao.UserDao;
import com.model.User;

public class Main {

	public static void main(String[] args) {
		
		User u = new User("akram", "aa@gmail.com", "123", "user");
		UserDao pd = new UserDao();
		int rs = pd.addUser(u);
		if(rs != 0) {
			System.out.println("Ajouter");
		}
		else {
			System.out.println("Non Ajouter");
		}

	}

}
