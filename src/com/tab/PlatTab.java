package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.db.DBConnect;
import com.mysql.jdbc.Connection;

public class PlatTab {
	private Connection connec;
	public PlatTab(Connection connec)
	{
		super();
		this.connec = connec;
	}
	public boolean addPlat(String nom_plat,String description_plat, String service, int prix_plat) {
		boolean f = false;
		try {
			String sql = "insert into plat( nom_plat, description_plat, service, prix_plat,date_service) values(?,?,?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, nom_plat);
			ps.setString(2, description_plat);
			ps.setString(3, service);
			ps.setInt(4, prix_plat);
		
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(format.format(date));
			ps.setString(5, format.format(date));
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public int nbPlat()
	{
		int a = 0;
		try{
			String sql = "SELECT * FROM plat where date_service = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			ps.setString(1, format.format(date));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a++;
			}

		}catch(Exception e){e.printStackTrace();}
		return a;
	}
	
}
