package com.agent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Agent;
import com.entity.User;
import com.mysql.jdbc.Connection;
import com.tab.AgentTab;

@WebServlet("/agentLogin")
public class AgentLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			HttpSession session = req.getSession();
			AgentTab u = new AgentTab((Connection)DBConnect.getConn());
			Agent f = u.loginAgent(email, password);
			if (f!=null) {
				session.setAttribute("AgentObj", new User(f.getId_agent(),f.getNom_agent(),f.getPrenom_agent(),f.getEmail(),f.getMot_de_passe_agent()));
				
				resp.sendRedirect("agent/index.jsp");
			} else {
				session.setAttribute("errorMsg", "email et mot de passe non valides");
				resp.sendRedirect("agent_login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
