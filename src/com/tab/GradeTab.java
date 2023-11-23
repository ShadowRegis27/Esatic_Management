package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Grade;
import com.mysql.jdbc.Connection;

public class GradeTab {
	private Connection connec;

	public GradeTab(Connection connec) {
		super();
		this.connec = connec;
	}
	public boolean ajoutGrade(Grade a)
	{
		boolean f  = false;
		try{
			String sql = "INSERT INTO grade(acronyme,designation_grade) VALUES(?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, a.getAcronyme());
			ps.setString(2, a.getDesignation_grade());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	public int getNbreGrade()
	{
		int a = 0;
		try{
			String sql = "select * from grade";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a++;
			}
		}catch(Exception e){e.printStackTrace();}
		return a;
	}
	public boolean updateGrade(Grade a)
	{
		boolean f = false;
		try{
			String sql="UPDATE grade SET acronyme=?,designation_grade=? WHERE id_grade= ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1,a.getAcronyme());
			ps.setString(2, a.getDesignation_grade());
			ps.setInt(3, a.getId_grade());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	
	public boolean deleteGrade(int id_grade)
	{
		boolean f = false;
		try{
			String sql = "DELETE FROM grade WHERE id_grade=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_grade);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	public List<Grade> allgrade()
	{
		List li = new ArrayList<Grade>();
		Grade f = null;
		try{
			String sql = "SELECT * FROM Grade";
			PreparedStatement ps = connec.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f= new Grade();
				f.setId_grade(rs.getInt(1));
				f.setAcronyme(rs.getString(2));
				f.setDesignation_grade(rs.getString(3));
				li.add(f);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return li;
	}
	public Grade GradefindOne(int id_grade)
	{
		Grade a = null;
		try{
			String sql="select * from grade where id_grade=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_grade);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Grade();
				a.setId_grade(rs.getInt(1));
				a.setAcronyme(rs.getString(2));
				a.setDesignation_grade(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
}
