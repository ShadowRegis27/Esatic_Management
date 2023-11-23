package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Grade;
import com.mysql.jdbc.Connection;
import com.tab.GradeTab;


@WebServlet("/addGrade")
public class AddGrade extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String acronyme = req.getParameter("acronyme");
			String designation_grade = req.getParameter("designation_grade");
			Grade a = new Grade(acronyme,designation_grade);
			GradeTab u = new GradeTab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.ajoutGrade(a)) {
				session.setAttribute("succMsg", "Grade crée avec succès..");
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
