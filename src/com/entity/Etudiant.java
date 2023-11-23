package com.entity;

public class Etudiant {
	private int id_etudiant;
	String nom_etudiant,prenom_etudiant,date_de_naissance_etudiant,matricule_etudiant,mot_de_passe_etudiant,email,numero,filiere;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String nom_etudiant, String prenom_etudiant,
			String date_de_naissance_etudiant, String matricule_etudiant,
			String mot_de_passe_etudiant, String email, String numero,
			String filiere) {
		super();
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.date_de_naissance_etudiant = date_de_naissance_etudiant;
		this.matricule_etudiant = matricule_etudiant;
		this.mot_de_passe_etudiant = mot_de_passe_etudiant;
		this.email = email;
		this.numero = numero;
		this.filiere = filiere;
	}
	public Etudiant(int id_etudiant, String nom_etudiant,
			String prenom_etudiant, String date_de_naissance_etudiant,
			String matricule_etudiant, String mot_de_passe_etudiant,
			String email, String numero, String filiere) {
		super();
		this.id_etudiant = id_etudiant;
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.date_de_naissance_etudiant = date_de_naissance_etudiant;
		this.matricule_etudiant = matricule_etudiant;
		this.mot_de_passe_etudiant = mot_de_passe_etudiant;
		this.email = email;
		this.numero = numero;
		this.filiere = filiere;
	}
	public int getId_etudiant() {
		return id_etudiant;
	}
	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	public String getNom_etudiant() {
		return nom_etudiant;
	}
	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}
	public String getPrenom_etudiant() {
		return prenom_etudiant;
	}
	public void setPrenom_etudiant(String prenom_etudiant) {
		this.prenom_etudiant = prenom_etudiant;
	}
	public String getDate_de_naissance_etudiant() {
		return date_de_naissance_etudiant;
	}
	public void setDate_de_naissance_etudiant(String date_de_naissance_etudiant) {
		this.date_de_naissance_etudiant = date_de_naissance_etudiant;
	}
	public String getMatricule_etudiant() {
		return matricule_etudiant;
	}
	public void setMatricule_etudiant(String matricule_etudiant) {
		this.matricule_etudiant = matricule_etudiant;
	}
	public String getMot_de_passe_etudiant() {
		return mot_de_passe_etudiant;
	}
	public void setMot_de_passe_etudiant(String mot_de_passe_etudiant) {
		this.mot_de_passe_etudiant = mot_de_passe_etudiant;
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
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	
}
