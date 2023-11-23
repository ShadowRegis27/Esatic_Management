package com.entity;

public class UE {
	private int id_ue;
	private String code_ue;
	private String intitule_ue;
	private int credit_ue;
	
	public UE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UE(String code_ue, String intitule_ue, int credit_ue) {
		super();
		this.code_ue = code_ue;
		this.intitule_ue = intitule_ue;
		this.credit_ue = credit_ue;
	}

	public UE(int id_ue, String code_ue, String intitule_ue, int credit_ue) {
		super();
		this.id_ue = id_ue;
		this.code_ue = code_ue;
		this.intitule_ue = intitule_ue;
		this.credit_ue = credit_ue;
	}

	public int getId_ue() {
		return id_ue;
	}

	public void setId_ue(int id_ue) {
		this.id_ue = id_ue;
	}

	public String getCode_ue() {
		return code_ue;
	}

	public void setCode_ue(String code_ue) {
		this.code_ue = code_ue;
	}

	public String getIntitule_ue() {
		return intitule_ue;
	}

	public void setIntitule_ue(String intitule_ue) {
		this.intitule_ue = intitule_ue;
	}

	public int getCredit_ue() {
		return credit_ue;
	}

	public void setCredit_ue(int credit_ue) {
		this.credit_ue = credit_ue;
	}
	
}
