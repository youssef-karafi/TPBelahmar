package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProduitDao;
import com.model.Produit;

/**
 * Servlet implementation class serve1
 */
@WebServlet("/serve1")
public class serve1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDao pm;

    public serve1() {
        super();
        
    }

	@Override
		public void init() throws ServletException {
		 pm = new ProduitDao();	
		}
    
    
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			
			int rs = pm.delete(id);
			if(rs != 0) {
				response.sendRedirect("produit");
			}
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		
		String designation = request.getParameter("designation");
		double prix = Double.parseDouble(request.getParameter("prix"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		String description = request.getParameter("description");
		
		if(request.getParameter("action").equalsIgnoreCase("ajouter")) {
			int rs = pm.addProduit(designation, prix, quantite, description);
			if(rs != 0) {
				response.sendRedirect("produit");
			}
		}
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			Produit p = new Produit(designation, prix, quantite, description);
			int rs = pm.update(id, p);
			if(rs != 0) {
				response.sendRedirect("produit");
			}
		}
		
		
	}

}
