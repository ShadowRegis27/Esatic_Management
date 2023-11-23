package com.agent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Filiere;
import com.mysql.jdbc.Connection;
import com.tab.FiliereTab;


@WebServlet("/addFiliere")
public class AddFiliere extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String acrofil = req.getParameter("acrofil");
			String descfil = req.getParameter("descfil");
			String niveaufil = req.getParameter("niveaufil");
			Filiere a = new Filiere(acrofil,descfil,niveaufil);
			FiliereTab u = new FiliereTab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.addFiliere(a)) {
				session.setAttribute("succMsg", "Une filière vient d'être crée..");
				resp.sendRedirect("agent/index.jsp");
			} else {
				session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
				resp.sendRedirect("agent/index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
