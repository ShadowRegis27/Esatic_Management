package com.entity;

public class Enseignant {
	private int id_enseignant;
	private String grade,specialite,nom_enseignant,prenom_enseignant,date_de_naissance_enseignant,matricule_enseignant,mot_de_passe_enseignant,email,numero;
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant( String nom_enseignant,
			String prenom_enseignant, String date_de_naissance_enseignant,
			String matricule_enseignant, String mot_de_passe_enseignant,
			String email, String numero,String grade, String specialite) {
		super();
		this.grade = grade;
		this.specialite = specialite;
		this.nom_enseignant = nom_enseignant;
		this.prenom_enseignant = prenom_enseignant;
		this.date_de_naissance_enseignant = date_de_naissance_enseignant;
		this.matricule_enseignant = matricule_enseignant;
		this.mot_de_passe_enseignant = mot_de_passe_enseignant;
		this.email = email;
		this.numero = numero;
	}
	public Enseignant(int id_enseignant,
			String nom_enseignant, String prenom_enseignant,
			String date_de_naissance_enseignant, String matricule_enseignant,
			String mot_de_passe_enseignant, String email, String numero,String grade, String specialite) {
		super();
		this.id_enseignant = id_enseignant;
		this.grade = grade;
		this.specialite = specialite;
		this.nom_enseignant = nom_enseignant;
		this.prenom_enseignant = prenom_enseignant;
		this.date_de_naissance_enseignant = date_de_naissance_enseignant;
		this.matricule_enseignant = matricule_enseignant;
		this.mot_de_passe_enseignant = mot_de_passe_enseignant;
		this.email = email;
		this.numero = numero;
	}
	public int getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getNom_enseignant() {
		return nom_enseignant;
	}
	public void setNom_enseignant(String nom_enseignant) {
		this.nom_enseignant = nom_enseignant;
	}
	public String getPrenom_enseignant() {
		return prenom_enseignant;
	}
	public void setPrenom_enseignant(String prenom_enseignant) {
		this.prenom_enseignant = prenom_enseignant;
	}
	public String getDate_de_naissance_enseignant() {
		return date_de_naissance_enseignant;
	}
	public void setDate_de_naissance_enseignant(String date_de_naissance_enseignant) {
		this.date_de_naissance_enseignant = date_de_naissance_enseignant;
	}
	public String getMatricule_enseignant() {
		return matricule_enseignant;
	}
	public void setMatricule_enseignant(String matricule_enseignant) {
		this.matricule_enseignant = matricule_enseignant;
	}
	public String getMot_de_passe_enseignant() {
		return mot_de_passe_enseignant;
	}
	public void setMot_de_passe_enseignant(String mot_de_passe_enseignant) {
		this.mot_de_passe_enseignant = mot_de_passe_enseignant;
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
