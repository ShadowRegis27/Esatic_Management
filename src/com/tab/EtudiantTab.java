package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Etudiant;
import com.mysql.jdbc.Connection;

public class EtudiantTab {
	private Connection connec;

	public EtudiantTab(Connection connec) {
		super();
		this.connec = connec;
	}
	
	public boolean addEtudiant(Etudiant e)
	{
		boolean f = false;
		try{
			String sql="INSERT INTO Etudiant(nom_etudiant, prenom_etudiant, date_de_naissance_etudiant, matricule_etudiant, mot_de_passe_etudiant, email, numero, filiere) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, e.getNom_etudiant());
			ps.setString(2, e.getPrenom_etudiant());
			ps.setString(3, e.getDate_de_naissance_etudiant());
			ps.setString(4, e.getMatricule_etudiant());
			ps.setString(5, e.getMot_de_passe_etudiant());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getNumero());
			ps.setString(8, e.getFiliere());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception g)
		{
			g.printStackTrace();
		}
		return f;
	}
	public boolean updateEtudiant(Etudiant e)
	{
		boolean f = false;
		try{
			String sql="UPDATE Etudiant SET nom_etudiant=?,prenom_etudiant=?,date_de_naissance_etudiant=?,matricule_etudiant=?,mot_de_passe_etudiant=?,email=?,numero=?,filiere=? WHERE id_etudiant=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, e.getNom_etudiant());
			ps.setString(2, e.getPrenom_etudiant());
			ps.setString(3, e.getDate_de_naissance_etudiant());
			ps.setString(4, e.getMatricule_etudiant());
			ps.setString(5, e.getMot_de_passe_etudiant());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getNumero());
			ps.setString(8, e.getFiliere());
			ps.setInt(9,e.getId_etudiant());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception g)
		{
			g.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteEtudiant(int id_etudiant)
	{
		boolean f = false;
		try{
			String sql="DELETE FROM Etudiant WHERE id_etudiant=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_etudiant);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public Etudiant getEtudiantbyId(int id_etudiant)
	{
		Etudiant f= null;
		try{
			String sql="SELECT * FROM Etudiant WHERE id_etudiant= ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_etudiant);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = new Etudiant();
				f.setId_etudiant(rs.getInt(1));
				f.setNom_etudiant(rs.getString(2));
				f.setPrenom_etudiant(rs.getString(3));
				f.setDate_de_naissance_etudiant(rs.getString(4));
				f.setMatricule_etudiant(rs.getString(5));
				f.setMot_de_passe_etudiant(rs.getString(6));
				f.setEmail(rs.getString(7));
				f.setNumero(rs.getString(8));
				f.setFiliere(rs.getString(9));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	public List<Etudiant> getEtudiantbyFiliere(String filiere)
	{
		List lo = new ArrayList<Etudiant>();
		Etudiant f = null;
		try{
			String sql="SELECT * FROM Etudiant WHERE filiere= ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, filiere);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = new Etudiant();
				f.setId_etudiant(rs.getInt(1));
				f.setNom_etudiant(rs.getString(2));
				f.setPrenom_etudiant(rs.getString(3));
				f.setDate_de_naissance_etudiant(rs.getString(4));
				f.setMatricule_etudiant(rs.getString(5));
				f.setMot_de_passe_etudiant(rs.getString(6));
				f.setEmail(rs.getString(7));
				f.setNumero(rs.getString(8));
				f.setFiliere(rs.getString(9));
				lo.add(f);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lo;
	}
}
