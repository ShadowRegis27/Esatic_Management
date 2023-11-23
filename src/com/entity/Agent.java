package com.entity;

public class Agent {
	private int id_agent; 
	private String nom_agent,prenom_agent,date_de_naissance_agent,matricule_agent, mot_de_passe_agent, email, numero;
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agent(String nom_agent, String prenom_agent,
			String date_de_naissance_agent, String matricule_agent,
			String mot_de_passe_agent, String email, String numero) {
		super();
		this.nom_agent = nom_agent;
		this.prenom_agent = prenom_agent;
		this.date_de_naissance_agent = date_de_naissance_agent;
		this.matricule_agent = matricule_agent;
		this.mot_de_passe_agent = mot_de_passe_agent;
		this.email = email;
		this.numero = numero;
	}
	
	

	public Agent(int id_agent, String nom_agent, String prenom_agent,
			String date_de_naissance_agent, String matricule_agent,
			String mot_de_passe_agent, String email, String numero) {
		super();
		this.id_agent = id_agent;
		this.nom_agent = nom_agent;
		this.prenom_agent = prenom_agent;
		this.date_de_naissance_agent = date_de_naissance_agent;
		this.matricule_agent = matricule_agent;
		this.mot_de_passe_agent = mot_de_passe_agent;
		this.email = email;
		this.numero = numero;
	}

	public int getId_agent() {
		return id_agent;
	}
	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}
	public String getNom_agent() {
		return nom_agent;
	}
	public void setNom_agent(String nom_agent) {
		this.nom_agent = nom_agent;
	}
	public String getPrenom_agent() {
		return prenom_agent;
	}
	public void setPrenom_agent(String prenom_agent) {
		this.prenom_agent = prenom_agent;
	}
	public String getDate_de_naissance_agent() {
		return date_de_naissance_agent;
	}
	public void setDate_de_naissance_agent(String date_de_naissance_agent) {
		this.date_de_naissance_agent = date_de_naissance_agent;
	}
	public String getMatricule_agent() {
		return matricule_agent;
	}
	public void setMatricule_agent(String matricule_agent) {
		this.matricule_agent = matricule_agent;
	}
	public String getMot_de_passe_agent() {
		return mot_de_passe_agent;
	}
	public void setMot_de_passe_agent(String mot_de_passe_agent) {
		this.mot_de_passe_agent = mot_de_passe_agent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
