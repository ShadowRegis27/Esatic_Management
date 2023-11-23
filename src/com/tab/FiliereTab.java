package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Filiere;
import com.mysql.jdbc.Connection;

public class FiliereTab {
	private Connection connec;

	public FiliereTab(Connection connec) {
		super();
		this.connec = connec;
	}
	
	public boolean addFiliere(Filiere f)
	{
		boolean a = false;
		try{
			String sql="INSERT INTO filiere( acrofil, descfil, niveaufil) VALUES (?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, f.getAcrofil());
			ps.setString(2, f.getDescfil());
			ps.setString(3, f.getNiveaufil());
			int i = ps.executeUpdate();
			if(i==1)
			{
				a = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
		
	}
	public boolean updateFiliere(Filiere f)
	{
		boolean a = false;
		try{
			String sql="UPDATE `filiere SET acrofil=?,descfil=?,niveaufil=? WHERE id_filiere=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, f.getAcrofil());
			ps.setString(2, f.getDescfil());
			ps.setString(3, f.getNiveaufil());
			ps.setInt(4, f.getId_filiere());
			int i = ps.executeUpdate();
			if(i==1)
			{
				a = true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	
	public boolean deleteFiliere(int id_filiere)
	{
		boolean a = false;
		try{
			String sql="DELETE FROM filiere WHERE id_filiere=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_filiere);
			int i = ps.executeUpdate();
			if(i==1)
			{
				a = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public Filiere getFilierebyAcro(String acrofil)
	{
		Filiere f = null;
		try{
			String sql="select * from filiere where acrofil = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, acrofil);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = new Filiere();
				f.setId_filiere(rs.getInt(1));
				f.setAcrofil(rs.getString(2));
				f.setDescfil(rs.getString(3));
				f.setNiveaufil(rs.getString(4));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public Filiere getFilierebyId(int id_filiere)
	{
		Filiere f = null;
		try{
			String sql="select * from filiere where id_filiere = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_filiere);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = new Filiere();
				f.setId_filiere(rs.getInt(1));
				f.setAcrofil(rs.getString(2));
				f.setDescfil(rs.getString(3));
				f.setNiveaufil(rs.getString(4));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Filiere> getAllFiliere()
	{
		List <Filiere> lf = new ArrayList<Filiere>();
		Filiere f = null;
		try{
			String sql = "SELECT * FROM filiere";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = new Filiere();
				f.setId_filiere(rs.getInt(1));
				f.setAcrofil(rs.getString(2));
				f.setDescfil(rs.getString(3));
				f.setNiveaufil(rs.getString(4));
				lf.add(f);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lf;
	}
	public int nbEtduiantbyFiliere(String filiere)
	{
		int a = 0;
		try{
			String sql="SELECT * FROM etudiant WHERE filiere = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, filiere);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
}
