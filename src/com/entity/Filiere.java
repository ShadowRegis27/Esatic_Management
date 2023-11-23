package com.entity;

public class Filiere {
	private int id_filiere;
	private String acrofil,descfil,niveaufil;
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filiere(String acrofil, String descfil, String niveaufil) {
		super();
		this.acrofil = acrofil;
		this.descfil = descfil;
		this.niveaufil = niveaufil;
	}
	public Filiere(int id_filiere, String acrofil, String descfil,
			String niveaufil) {
		super();
		this.id_filiere = id_filiere;
		this.acrofil = acrofil;
		this.descfil = descfil;
		this.niveaufil = niveaufil;
	}
	public int getId_filiere() {
		return id_filiere;
	}
	public void setId_filiere(int id_filiere) {
		this.id_filiere = id_filiere;
	}
	public String getAcrofil() {
		return acrofil;
	}
	public void setAcrofil(String acrofil) {
		this.acrofil = acrofil;
	}
	public String getDescfil() {
		return descfil;
	}
	public void setDescfil(String descfil) {
		this.descfil = descfil;
	}
	public String getNiveaufil() {
		return niveaufil;
	}
	public void setNiveaufil(String niveaufil) {
		this.niveaufil = niveaufil;
	}
	
}
