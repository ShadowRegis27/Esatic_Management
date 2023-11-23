package com.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

@WebServlet("/restLogin")
public class RestLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			HttpSession session = req.getSession();

			if ("rest@gmail.com".equals(email) && "rest".equals(password)) {
				session.setAttribute("restObj", new User());
				
				resp.sendRedirect("rest/index.jsp");
			} else {
				session.setAttribute("errorMsg", "email et mot de passe non valides");
				resp.sendRedirect("restaurateur_login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}