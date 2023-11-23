package com.agent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.ECUE;
import com.mysql.jdbc.Connection;
import com.tab.ECUETab;


@WebServlet("/addECUE")
public class AddECUE extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String code_ecue = req.getParameter("code_ecue");
			String intitule_ecue = req.getParameter("intitule_ecue");
			String ue_ecue = req.getParameter("ue_ecue");
			Double credit_ecue = Double.parseDouble(req.getParameter("credit_ecue"));
			ECUE a = new ECUE(code_ecue,intitule_ecue,credit_ecue,ue_ecue);
			ECUETab u = new ECUETab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.addECUE(a)) {
				session.setAttribute("succMsg", "Un élément constitutif d'une unité d'enseignement vient d'être crée..");
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
