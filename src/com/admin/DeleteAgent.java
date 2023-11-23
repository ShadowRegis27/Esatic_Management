package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.db.DBConnect;
import com.mysql.jdbc.Connection;
import com.tab.AgentTab;

@WebServlet("/deleteAgent")
public class DeleteAgent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id_agent"));
		
		AgentTab dao = new AgentTab((Connection)DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.deleteAgent(id)) {
			session.setAttribute("succMsg", " Suppression réussie..");
			resp.sendRedirect("admin/edit_agent.jsp");
		} else {
			session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
			resp.sendRedirect("admin/edit_agent.jsp");
		}
		

	}

}
