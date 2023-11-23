package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.UE;
import com.mysql.jdbc.Connection;

public class UETab{
	private Connection connec;

	public UETab(Connection connec) {
		super();
		this.connec = connec;
	}
	
	public boolean addUE(UE u)
	{
		boolean f = false;
		try{
			String sql="INSERT INTO ue(code_ue, intitule_ue, credit_ue) VALUES (?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, u.getCode_ue());
			ps.setString(2, u.getIntitule_ue());
			ps.setInt(3,u.getCredit_ue());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean updateUE(UE u)
	{
		boolean f =false;
		try{
			String sql="UPDATE ue SET code_ue=?,intitule_ue=?,credit_ue=? WHERE id_ue=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, u.getCode_ue());
			ps.setString(2, u.getIntitule_ue());
			ps.setInt(3,u.getCredit_ue());
			ps.setInt(4,u.getId_ue());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteUE(int id_ue)
	{
		boolean f = false;
		try{
			String sql="DELETE FROM ue WHERE id_ue=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1,id_ue);
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public UE getUEbyId(int id_ue)
	{
		UE u = null;
		try{
			String sql="SELECT * FROM ue WHERE id_ue=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1,id_ue);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new UE();
				u.setId_ue(rs.getInt(1));
				u.setCode_ue(rs.getString(2));
				u.setIntitule_ue(rs.getString(3));
				u.setCredit_ue(rs.getInt(4));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
	}
	
	public List<UE> getAllUE()
	{
		List lue = new ArrayList<UE>();
		UE u = null;
		try{
			String sql="SELECT * FROM ue";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new UE();
				u.setId_ue(rs.getInt(1));
				u.setCode_ue(rs.getString(2));
				u.setIntitule_ue(rs.getString(3));
				u.setCredit_ue(rs.getInt(4));
				lue.add(u);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return lue;
	}
}
