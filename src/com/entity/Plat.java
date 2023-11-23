package com.entity;

public class Plat {
	private int id_plat;

	private int nom_plat;

	private String description_plat;

	private String service;

	private int prix_plat;

	public Plat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plat(int id_plat, int nom_plat, String description_plat,
			String service, int prix_plat) {
		super();
		this.id_plat = id_plat;
		this.nom_plat = nom_plat;
		this.description_plat = description_plat;
		this.service = service;
		this.prix_plat = prix_plat;
	}

	public int getId_plat() {
		return id_plat;
	}

	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}

	public int getNom_plat() {
		return nom_plat;
	}

	public void setNom_plat(int nom_plat) {
		this.nom_plat = nom_plat;
	}

	public String getDescription_plat() {
		return description_plat;
	}

	public void setDescription_plat(String description_plat) {
		this.description_plat = description_plat;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getPrix_plat() {
		return prix_plat;
	}

	public void setPrix_plat(int prix_plat) {
		this.prix_plat = prix_plat;
	}
	
	
}
