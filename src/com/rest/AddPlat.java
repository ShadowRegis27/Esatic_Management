package com.rest;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.tab.PlatTab;
import com.db.DBConnect;
import com.entity.User;
@WebServlet("/addPlat")
public class AddPlat extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom_plat = req.getParameter("nom_plat");
		String description_plat = req.getParameter("description_plat");
		String service = req.getParameter("service");
		int prix_plat = Integer.parseInt(req.getParameter("prix_plat"));
		PlatTab plat = new PlatTab((Connection) DBConnect.getConn());
		boolean f = plat.addPlat(nom_plat, description_plat, service, prix_plat);
		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Plat ajouté");
			resp.sendRedirect("rest/index.jsp");
		} else {
			session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
			resp.sendRedirect("rest/index.jsp");
		}

	}

}
