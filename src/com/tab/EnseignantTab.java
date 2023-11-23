package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Enseignant;
import com.mysql.jdbc.Connection;

public class EnseignantTab {
	private Connection connec;

	public EnseignantTab(Connection connec) {
		super();
		this.connec = connec;
	}
	public boolean registerEnseignant(Enseignant o)
	{
		boolean f = false;
		try{
			String sql="INSERT INTO enseignant(nom_enseignant, prenom_enseignant, date_de_naissance_enseignant, matricule_enseignant, mot_de_passe_enseignant, email, numero, grade, specialite) VALUES(?,?,?,?,?,?,?,?,?) ";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, o.getNom_enseignant());
			ps.setString(2, o.getPrenom_enseignant());
			ps.setString(3, o.getDate_de_naissance_enseignant());
			ps.setString(4, o.getMatricule_enseignant());
			ps.setString(5, o.getMot_de_passe_enseignant());
			ps.setString(6, o.getEmail());
			ps.setString(7, o.getNumero());
			ps.setString(8, o.getGrade());
			ps.setString(9, o.getSpecialite());
			int i = ps.executeUpdate();
			if(i==1){
				f=true;
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean updateEnseignant(Enseignant o)
	{
		boolean f = false;
		try{
			String sql="UPDATE enseignant SET nom_enseignant=?,prenom_enseignant=?,date_de_naissance_enseignant=?,matricule_enseignant=?,mot_de_passe_enseignant=?,email=?,numero=?,grade=?,specialite=? WHERE id_enseignant = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, o.getNom_enseignant());
			ps.setString(2, o.getPrenom_enseignant());
			ps.setString(3, o.getDate_de_naissance_enseignant());
			ps.setString(4, o.getMatricule_enseignant());
			ps.setString(5, o.getMot_de_passe_enseignant());
			ps.setString(6, o.getEmail());
			ps.setString(7, o.getNumero());
			ps.setString(8, o.getGrade());
			ps.setString(9, o.getSpecialite());
			ps.setInt(10, o.getId_enseignant());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteEnseignant(int id_enseignant)
	{
		boolean f = false;
		try{
			String sql = "DELETE FROM enseignant WHERE id_enseignant = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_enseignant);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Enseignant> getAllEnseignant()
	{
		List l = new ArrayList<Enseignant>();
		Enseignant o = null;
		try{
			o = new Enseignant();
			String sql = "SELECT * FROM enseignant";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o.setId_enseignant(rs.getInt(1));
				o.setNom_enseignant(rs.getString(2));
				o.setPrenom_enseignant(rs.getString(3));
				o.setDate_de_naissance_enseignant(rs.getString(4));
				o.setMatricule_enseignant(rs.getString(5));
				o.setMot_de_passe_enseignant(rs.getString(6));
				o.setEmail(rs.getString(7));
				o.setNumero(rs.getString(8));
				o.setGrade(rs.getString(9));
				o.setSpecialite(rs.getString(10));
				l.add(o);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}
	
	public Enseignant getEnseignantById(int id_enseignant)
	{
		Enseignant o = null;
		try{
			o = new Enseignant();
			String sql = "SELECT * FROM enseignant WHERE id_enseignant = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_enseignant);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o.setId_enseignant(rs.getInt(1));
				o.setNom_enseignant(rs.getString(2));
				o.setPrenom_enseignant(rs.getString(3));
				o.setDate_de_naissance_enseignant(rs.getString(4));
				o.setMatricule_enseignant(rs.getString(5));
				o.setMot_de_passe_enseignant(rs.getString(6));
				o.setEmail(rs.getString(7));
				o.setNumero(rs.getString(8));
				o.setGrade(rs.getString(9));
				o.setSpecialite(rs.getString(10));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return o;
	}
}
