package com.entity;

public class Grade {
	 private int id_grade;
	private String acronyme,designation_grade;
	public int getId_grade() {
		return id_grade;
	}
	public void setId_grade(int id_grade) {
		this.id_grade = id_grade;
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	public String getDesignation_grade() {
		return designation_grade;
	}
	public void setDesignation_grade(String designation_grade) {
		this.designation_grade = designation_grade;
	}
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String acronyme, String designation_grade) {
		super();
		this.acronyme = acronyme;
		this.designation_grade = designation_grade;
	}
	public Grade(int id_grade, String acronyme, String designation_grade) {
		super();
		this.id_grade = id_grade;
		this.acronyme = acronyme;
		this.designation_grade = designation_grade;
	}
	
}
