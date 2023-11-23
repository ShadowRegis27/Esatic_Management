package com.entity;

public class ECUE {
	private int id_ecue;
	private String code_ecue;
	private String intitule_ecue;
	private double credit_ecue;
	private String ue_ecue;
	public ECUE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ECUE(String code_ecue, String intitule_ecue, double credit_ecue,
			String ue_ecue) {
		super();
		this.code_ecue = code_ecue;
		this.intitule_ecue = intitule_ecue;
		this.credit_ecue = credit_ecue;
		this.ue_ecue = ue_ecue;
	}
	public ECUE(int id_ecue, String code_ecue, String intitule_ecue,
			double credit_ecue, String ue_ecue) {
		super();
		this.id_ecue = id_ecue;
		this.code_ecue = code_ecue;
		this.intitule_ecue = intitule_ecue;
		this.credit_ecue = credit_ecue;
		this.ue_ecue = ue_ecue;
	}
	public int getId_ecue() {
		return id_ecue;
	}
	public void setId_ecue(int id_ecue) {
		this.id_ecue = id_ecue;
	}
	public String getCode_ecue() {
		return code_ecue;
	}
	public void setCode_ecue(String code_ecue) {
		this.code_ecue = code_ecue;
	}
	public String getIntitule_ecue() {
		return intitule_ecue;
	}
	public void setIntitule_ecue(String intitule_ecue) {
		this.intitule_ecue = intitule_ecue;
	}
	public double getCredit_ecue() {
		return credit_ecue;
	}
	public void setCredit_ecue(double credit_ecue) {
		this.credit_ecue = credit_ecue;
	}
	public String getUe_ecue() {
		return ue_ecue;
	}
	public void setUe_ecue(String ue_ecue) {
		this.ue_ecue = ue_ecue;
	}
	
}
