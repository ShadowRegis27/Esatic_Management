package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnect;
import com.entity.Enseignant;
import com.mysql.jdbc.Connection;
import com.tab.EnseignantTab;

@WebServlet("/updateEnseignant")
public class UpdateEnseignant extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String nom_enseignant = req.getParameter("nom_enseignant");
			String prenom_enseignant = req.getParameter("prenom_enseignant");
			String date_de_naissance_enseignant = req.getParameter("date_de_naissance_enseignant");
			String matricule_enseignant = req.getParameter("matricule_enseignant");
			String mot_de_passe_enseignant = req.getParameter("mot_de_passe_enseignant");
			String email = req.getParameter("email");
			String numero = req.getParameter("numero");
			String grade = req.getParameter("grade");
			String specialite = req.getParameter("specialite");
			int id_enseignant = Integer.parseInt(req.getParameter("id_enseignant"));
			Enseignant a = new Enseignant(id_enseignant,nom_enseignant,prenom_enseignant,date_de_naissance_enseignant,matricule_enseignant,mot_de_passe_enseignant,email,numero,grade,specialite);
			EnseignantTab u = new EnseignantTab((Connection)DBConnect.getConn());
			HttpSession session = req.getSession();

			if (u.updateEnseignant(a)) {
				session.setAttribute("succMsg", "Modification faites avec succès ..");
				resp.sendRedirect("admin/edit_enseignant.jsp");
			} else {
				session.setAttribute("errorMsg", "Quelque chose ne va pas sur le serveur");
				resp.sendRedirect("admin/edit_enseignant.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

}
}
