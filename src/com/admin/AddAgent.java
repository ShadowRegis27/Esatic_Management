package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Agent;
import com.mysql.jdbc.Connection;
import com.tab.AgentTab;


@WebServlet("/addAgent")
public class AddAgent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String nom_agent = req.getParameter("nom_agent");
			String prenom_agent = req.getParameter("prenom_agent");
			String date_de_naissance_agent = req.getParameter("date_de_naissance_agent");
			String matricule_agent = req.getParameter("matricule_agent");
			String mot_de_passe_agent = req.getParameter("mot_de_passe_agent");
			String email = req.getParameter("email");
			String numero = req.getParameter("numero");

			Agent a = new Agent(nom_agent,prenom_agent,date_de_naissance_agent,matricule_agent,mot_de_passe_agent,email,numero);
			AgentTab u = new AgentTab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.registeragent(a)) {
				session.setAttribute("succMsg", "Agent crée avec succès..");
				resp.sendRedirect("admin/agent.jsp");
			} else {
				session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
				resp.sendRedirect("admin/agent.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
