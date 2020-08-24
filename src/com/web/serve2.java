package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class serve2
 */
@WebServlet("/serve2")
public class serve2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao ud ;
    int cpt=0;
    public serve2() {
        super();
    }

    
    @Override
    	public void init() throws ServletException {
    		ud = new UserDao();
    	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String log = request.getParameter("login");
		String pass = request.getParameter("password");
		User u = ud.Authentification(log, pass);
		if(u != null) {
			HttpSession sess =  request.getSession();
			sess.setAttribute("user", u);
			response.sendRedirect("produit");
			
		}
		else {
			cpt++;
			request.setAttribute("msg", "login ou password incorrects");
			request.setAttribute("cpt",cpt);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
