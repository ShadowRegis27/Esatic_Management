package com.tab;

import com.entity.Grade;
import com.entity.Specialite;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class SpecialiteTab {
	private Connection connec;

	public SpecialiteTab(Connection connec) {
		super();
		this.connec = connec;
	}
	public boolean addSpecialite(Specialite s)
	{
		boolean f = false;
		try{
			String sql="INSERT INTO specialite(desspec) VALUES(?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, s.getDesspec());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	public int NbSpecialiste()
	{
		int a = 0;
		try{
			String sql = "SELECT * FROM specialite";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a++;
			}

		}catch(Exception e){e.printStackTrace();}
		return a;
	}
	public boolean updateSpecialite(Specialite s)
	{
		boolean f = false;
		try{
			String sql = "UPDATE specialite SET desspec = ? WHERE id_spec=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, s.getDesspec());
			ps.setInt(2, s.getId_spec());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	public boolean deleteSpecialite(int id_spec)
	{
		boolean f = false;
		try{
			String sql = "DELETE FROM specialite WHERE id_spec=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_spec);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	public List<Specialite> allSpec()
	{
		List lo = new ArrayList<Specialite>();
		Specialite  p = null;
		try{
			String sql="SELECT * FROM specialite";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p= new Specialite();
				p.setId_spec(rs.getInt(1));
				p.setDesspec(rs.getString(2));
				lo.add(p);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lo;
	}
	
	public Specialite SpecfindOne(int id_spec)
	{
		Specialite s = null;
		try{
			String sql="select * from specialite id_spec=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_spec);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s= new Specialite();
				s.setId_spec(rs.getInt(1));
				s.setDesspec(rs.getString(2));
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
}
