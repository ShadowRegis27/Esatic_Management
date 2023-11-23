package com.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Agent;
import com.mysql.jdbc.Connection;

public class AgentTab {
	private Connection connec;
		public AgentTab(Connection connec)
	{
		super();
		this.connec = connec;
	}
	public boolean registeragent(Agent a)
	{
		boolean f = false;
		try{
			String sql="INSERT INTO agent(nom_agent, prenom_agent, date_de_naissance_agent, matricule_agent, mot_de_passe_agent, email, numero) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, a.getNom_agent());
			ps.setString(2, a.getPrenom_agent());
			ps.setString(3, a.getDate_de_naissance_agent());
			ps.setString(4, a.getMatricule_agent());
			ps.setString(5, a.getMot_de_passe_agent());
			ps.setString(6, a.getEmail());
			ps.setString(7, a.getNumero());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	public Agent getagent(int id_agent)
	{
		Agent a =null;
		try {

			String sql = "select * from agent where id_agent=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_agent);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				a = new Agent();
				a.setId_agent(rs.getInt(1));
				a.setNom_agent(rs.getString(2));
				a.setPrenom_agent(rs.getString(3));
				a.setDate_de_naissance_agent(rs.getString(4));
				a.setMatricule_agent(rs.getString(5));
				a.setMot_de_passe_agent(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setNumero(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public boolean updateagent(Agent a)
	{
		boolean f =false;
		try
		{
			String sql = "update agent set nom_agent=?,prenom_agent=?,date_de_naissance_agent=?,matricule_agent=?,mot_de_passe_agent=?,email= ?, numero=? where id_agent=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, a.getNom_agent());
			ps.setString(2, a.getPrenom_agent());
			ps.setString(3, a.getDate_de_naissance_agent());
			ps.setString(4, a.getMatricule_agent());
			ps.setString(5, a.getMot_de_passe_agent());
			ps.setString(6, a.getEmail());
			ps.setString(7, a.getNumero());
			ps.setInt(8, a.getId_agent());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Agent> getAllAgent()
	{
		List<Agent> r = new ArrayList<Agent>();
		Agent a = null;
		try{
			String sql = "select * from agent order by id_agent desc";
			PreparedStatement ps = connec.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Agent();
				a.setId_agent(rs.getInt(1));
				a.setNom_agent(rs.getString(2));
				a.setPrenom_agent(rs.getString(3));
				a.setDate_de_naissance_agent(rs.getString(4));
				a.setMatricule_agent(rs.getString(5));
				a.setMot_de_passe_agent(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setNumero(rs.getString(8));
				r.add(a);
			}

		}catch(Exception e){e.printStackTrace();}
		return r;
	}
	
	public Agent getAgentById(int id_agent)
	{
		Agent a = null;
		try {

			String sql = "select * from agent where id_agent=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_agent);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				a = new Agent();
				a.setId_agent(rs.getInt(1));
				a.setNom_agent(rs.getString(2));
				a.setPrenom_agent(rs.getString(3));
				a.setDate_de_naissance_agent(rs.getString(4));
				a.setMatricule_agent(rs.getString(5));
				a.setMot_de_passe_agent(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setNumero(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public boolean deleteAgent(int id_agent)
	{
		boolean f=false;
		try{
			String sql ="DELETE FROM agent WHERE id_agent = ?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setInt(1, id_agent);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		}catch(Exception e){e.printStackTrace();}
		return f;
	}
	
	public Agent loginAgent(String 	email, String mot_de_passe_agent)
	{
		Agent a = null;
		try{
			String sql="SELECT * FROM agent WHERE email=? and mot_de_passe_agent=?";
			PreparedStatement ps = connec.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, mot_de_passe_agent);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				a = new Agent();
				a.setId_agent(rs.getInt(1));
				a.setNom_agent(rs.getString(2));
				a.setPrenom_agent(rs.getString(3));
				a.setDate_de_naissance_agent(rs.getString(4));
				a.setMatricule_agent(rs.getString(5));
				a.setMot_de_passe_agent(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setNumero(rs.getString(8));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
}
