package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ECUE;
import com.mysql.jdbc.Connection;

public class ECUETab {
	private Connection connec;

	public ECUETab(Connection connec) {
		super();
		this.connec = connec;
	}
	
	public boolean addECUE(ECUE eu)
	{
		boolean f = false;
		try{
			String sql="INSERT INTO ecue(code_ecue, intitule_ecue, credit_ecue,ue_ecue) VALUES (?,?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, eu.getCode_ecue());
			ps.setString(2, eu.getIntitule_ecue());
			ps.setDouble(3, eu.getCredit_ecue());
			ps.setString(4, eu.getUe_ecue());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	public boolean updateECUE(ECUE eu)
	{
		boolean f = false;
		try{
			String sql="UPDATE ecue SET code_ecue=?,intitule_ecue=?,credit_ecue=?,ue_ecue=? WHERE id_ecue = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, eu.getCode_ecue());
			ps.setString(2, eu.getIntitule_ecue());
			ps.setDouble(3, eu.getCredit_ecue());
			ps.setString(4, eu.getUe_ecue());
			ps.setInt(5, eu.getId_ecue());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteECUE(int id_ecue)
	{
		boolean f = false;
		try{
			String sql="DELETE FROM ecue WHERE id_ecue = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_ecue);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	
	public ECUE getECUEbyID(int id_ecue)
	{
		ECUE ue = null;
		try{
			String sql="SELECT * FROM ecue WHERE id_ecue = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1,id_ecue);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ue = new ECUE();
				ue.setId_ecue(rs.getInt(1));
				ue.setCode_ecue(rs.getString(2));
				ue.setIntitule_ecue(rs.getString(3));
				ue.setCredit_ecue(rs.getDouble(4));
				ue.setUe_ecue(rs.getString(5));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ue;
	}
	public List<ECUE> getAllECUE()
	{
		List all = new ArrayList<ECUE>();
		ECUE ue = null;
		try{
			String sql="SELECT * FROM ecue";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ue = new ECUE();
				ue.setId_ecue(rs.getInt(1));
				ue.setCode_ecue(rs.getString(2));
				ue.setIntitule_ecue(rs.getString(3));
				ue.setCredit_ecue(rs.getDouble(4));
				ue.setUe_ecue(rs.getString(5));
				all.add(ue);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return all;
	}
}
