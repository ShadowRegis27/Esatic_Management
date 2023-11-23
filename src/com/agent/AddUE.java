package com.agent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.UE;
import com.mysql.jdbc.Connection;
import com.tab.UETab;


@WebServlet("/addUE")
public class AddUE extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String code_ue = req.getParameter("code_ue");
			String intitule_ue = req.getParameter("intitule_ue");
			int credit_ue = Integer.parseInt(req.getParameter("credit_ue"));
			UE a = new UE(code_ue,intitule_ue,credit_ue);
			UETab u = new UETab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.addUE(a)) {
				session.setAttribute("succMsg", "Une Nouvelle unité d'enseignement à été crée..");
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
