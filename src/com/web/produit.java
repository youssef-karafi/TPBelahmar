package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProduitDao;
import com.model.Produit;
import com.model.User;

/**
 * Servlet implementation class produit
 */
@WebServlet("/produit")
public class produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitDao pm;
       
  
    public produit() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		pm = new ProduitDao();
	}

	public void destroy() {
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Produit> produits = pm.allProduit();
		HttpSession sess =  request.getSession();
		User u = (User) sess.getAttribute("user");
		
		out.print("<H3> Hello : "+u.getNom()+" ***  "+u.getLog()+" <H3>");
		out.print("<Hr><br>");
		if(u.getRole().equals("admin")) {		
		int id = 0;
		String designation = "";
		double  prix = 0.0;
		int quantite = 0;
		String description ="";
		String action = "Ajouter";
		
		
        if(request.getParameter("op") != null) {
        	if(request.getParameter("op").equals("edit")) {
        		 id = Integer.parseInt(request.getParameter("id"));
        		 Produit p = pm.findProduitById(id);
        		 designation = p.getDesignation();
        		 prix = p.getPrix();
        		 quantite = p.getQuantite();
        		 description = p.getDescription();
        		 action = "Update";
        	}
        }
		out.print("<form action='serve1' method='post'>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td><label>Id</label></td>");
		out.print("<td><input type='number' readonly name='id' value='"+id+"'/></td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<td><label>Designation</label></td>");
		out.print("<td><input type='text' name='designation' value='"+designation+"'/></td>");
		out.print("</tr>");
				
		out.print("<tr>");
		out.print("<td><label>Prix</label></td>");
		out.print("<td><input type='number' name='prix' value='"+prix+"'/></td>");
		out.print("</tr>");
				
		out.print("<tr>");
		out.print("<td><label>Quantite</label></td>");
		out.print("<td><input type='number' name='quantite' value='"+quantite+"'/></td>");
		out.print("</tr>");
				
		out.print("<tr>");
		out.print("<td><label>Description</label></td>");
		out.print("<td><input type='text' name='description' value='"+description+"'/></td>");
		out.print("</tr>");
				
		out.print("<tr>");
		
		out.print("<td><input type='submit' value='"+action+"' name='action' /></td>");
		out.print("<td><input type='reset' value='Annuler' /></td>");
		out.print("</tr>");
		
		out.print("</table>");
		out.print("</form>");
		
		out.print("<hr>");
		
		}
		
		
		out.print("<table border='1' bgcolor='gold' width='800' ><thead>");
		out.print("<tr>");
		out.print("<th>ID</th>");
		out.print("<th>Designation</th>");
		out.print("<th>Prix</th>");
		out.print("<th>Quantite</th>");
		out.print("<th>Description</th>");
		
		if(u.getRole().equals("admin")) {
			out.print("<th>Supprimer</th>");
			out.print("<th>Modifier</th>");	
		}
		out.print("</tr>");
		out.print("</thead>");
		out.print("<tbody>");
		for(Produit p : produits ) {
			out.print("<tr>");
			out.print("<td>"+p.getId()+"</td>");
			out.print("<td>"+p.getDesignation()+"</td>");
			out.print("<td>"+p.getPrix()+"</td>");
			out.print("<td>"+p.getQuantite()+"</td>");
			out.print("<td>"+p.getDescription()+"</td>");
			
			if(u.getRole().equals("admin")) {
				out.print("<td>");
				out.print("<a href='serve1?id="+p.getId()+"' >delete</a>");
				out.print("</td>");
				
				out.print("<td>");
				out.print("<a href='?op=edit&id="+p.getId()+"'>update</a>");
				out.print("</td>");	
			}
		
			out.print("</tr>");
		}		
		out.print("</tbody>");
		out.print("</table>");
	}

}
