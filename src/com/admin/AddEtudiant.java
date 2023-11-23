package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Etudiant;
import com.mysql.jdbc.Connection;
import com.tab.EtudiantTab;


@WebServlet("/addEtudiant")
public class AddEtudiant extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String nom_etudiant = req.getParameter("nom_etudiant");
			String prenom_etudiant = req.getParameter("prenom_etudiant");
			String date_de_naissance_etudiant = req.getParameter("date_de_naissance_etudiant");
			String matricule_etudiant = req.getParameter("matricule_etudiant");
			String mot_de_passe_etudiant = req.getParameter("mot_de_passe_etudiant");
			String email = req.getParameter("email");
			String numero = req.getParameter("numero");
			String filiere = req.getParameter("filiere");
			Etudiant a = new Etudiant(nom_etudiant,prenom_etudiant,date_de_naissance_etudiant,matricule_etudiant,mot_de_passe_etudiant,email,numero,filiere);
			EtudiantTab u = new EtudiantTab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.addEtudiant(a)) {
				session.setAttribute("succMsg", "Etudiant enregistré..");
				resp.sendRedirect("admin/etudiant.jsp");
			} else {
				session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
				resp.sendRedirect("admin/etudiant.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
