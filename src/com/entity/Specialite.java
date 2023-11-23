package com.entity;

public class Specialite {
	private int id_spec;
	private String desspec;
	
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Specialite(String desspec) {
		super();
		this.desspec = desspec;
	}
	
	
	public Specialite(int id_spec, String desspec) {
		super();
		this.id_spec = id_spec;
		this.desspec = desspec;
	}

	public int getId_spec() {
		return id_spec;
	}
	public void setId_spec(int id_spec) {
		this.id_spec = id_spec;
	}
	public String getDesspec() {
		return desspec;
	}
	public void setDesspec(String desspec) {
		this.desspec = desspec;
	}
	
}
