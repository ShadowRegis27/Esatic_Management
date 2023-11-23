package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Specialite;
import com.mysql.jdbc.Connection;
import com.tab.SpecialiteTab;

@WebServlet("/addSpecialite")
public class AddSepcialite extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String desspec = req.getParameter("desspec");
			
			Specialite a = new Specialite(desspec);
			SpecialiteTab u = new SpecialiteTab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.addSpecialite(a)) {
				session.setAttribute("succMsg", "Spécialité ajoutée avec succès..");
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
				resp.sendRedirect("admin/index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
