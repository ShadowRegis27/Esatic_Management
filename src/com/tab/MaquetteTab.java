package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Maquette;
import com.mysql.jdbc.Connection;

public class MaquetteTab {
	private Connection connec;

	public MaquetteTab(Connection connec) {
		super();
		this.connec = connec;
	}
	
	public boolean addMaquette(Maquette m)
	{
		boolean f=false;
		try{
			String sql="INSERT INTO maquete(filiere_ma, semestre, ue_1, ue_2, ue_3, ue_4, ue_5, ue_6, ue_7, ue_8, ue_9, ue_10) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, m.getFiliere_ma());
			ps.setString(2, m.getSemestre());
			ps.setString(3, m.getUe_1());
			ps.setString(4, m.getUe_2());
			ps.setString(5, m.getUe_3());
			ps.setString(6, m.getUe_4());
			ps.setString(7, m.getUe_5());
			ps.setString(8, m.getUe_6());
			ps.setString(9, m.getUe_7());
			ps.setString(10, m.getUe_8());
			ps.setString(11, m.getUe_9());
			ps.setString(12, m.getUe_10());
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
	
	public boolean updateMaquette(Maquette m)
	{
		boolean f=false;
		try{
			String sql="UPDATE maquete SET filiere_ma=?,semestre=?,ue_1=?,ue_2=?,ue_3=?,ue_4=?,ue_5=?,ue_6=?,ue_7=?,ue_8=?,ue_9=?,ue_10=? WHERE id_maquette=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, m.getFiliere_ma());
			ps.setString(2, m.getSemestre());
			ps.setString(3, m.getUe_1());
			ps.setString(4, m.getUe_2());
			ps.setString(5, m.getUe_3());
			ps.setString(6, m.getUe_4());
			ps.setString(7, m.getUe_5());
			ps.setString(8, m.getUe_6());
			ps.setString(9, m.getUe_7());
			ps.setString(10, m.getUe_8());
			ps.setString(11, m.getUe_9());
			ps.setString(12, m.getUe_10());
			ps.setInt(13, m.getId_maquette());
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
	
	public boolean deleteMaquette(int id_maquette)
	{
		boolean f = false;
		try{
			String sql="DELETE FROM maquete WHERE id_maquette=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_maquette);
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
	
	public Maquette getMaquettebyId(int id_maquette)
	{
		Maquette m = null;
		try{
			String sql="SELECT * FROM maquete WHERE id_maquette=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_maquette);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Maquette();
				m.setId_maquette(rs.getInt(1));
				m.setFiliere_ma(rs.getString(2));
				m.setSemestre(rs.getString(3));
				m.setUe_1(rs.getString(4));
				m.setUe_2(rs.getString(5));
				m.setUe_3(rs.getString(6));
				m.setUe_4(rs.getString(7));
				m.setUe_5(rs.getString(8));
				m.setUe_6(rs.getString(9));
				m.setUe_7(rs.getString(10));
				m.setUe_8(rs.getString(11));
				m.setUe_9(rs.getString(12));
				m.setUe_10(rs.getString(13));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	public List<Maquette> getAllMaquette()
	{
		List<Maquette> ml = new ArrayList<Maquette>();
		Maquette m = null;
		try{
			String sql="SELECT * FROM maquete";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Maquette();
				m.setId_maquette(rs.getInt(1));
				m.setFiliere_ma(rs.getString(2));
				m.setSemestre(rs.getString(3));
				m.setUe_1(rs.getString(4));
				m.setUe_2(rs.getString(5));
				m.setUe_3(rs.getString(6));
				m.setUe_4(rs.getString(7));
				m.setUe_5(rs.getString(8));
				m.setUe_6(rs.getString(9));
				m.setUe_7(rs.getString(10));
				m.setUe_8(rs.getString(11));
				m.setUe_9(rs.getString(12));
				m.setUe_10(rs.getString(13));
				ml.add(m);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ml;
	}
}
