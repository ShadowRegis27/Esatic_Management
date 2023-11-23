package com.entity;

public class Maquette {
	private int id_maquette;
	private String filiere_ma;
	private String semestre;
	private String ue_1;
	private String ue_2;
	private String ue_3;
	private String ue_4;
	private String ue_5;
	private String ue_6;
	private String ue_7;
	private String ue_8;
	private String ue_9;
	private String ue_10;
	public Maquette() {
		super();
	}
	public Maquette(String filiere_ma, String semestre, String ue_1,
			String ue_2, String ue_3, String ue_4, String ue_5, String ue_6,
			String ue_7, String ue_8, String ue_9, String ue_10) {
		super();
		this.filiere_ma = filiere_ma;
		this.semestre = semestre;
		this.ue_1 = ue_1;
		this.ue_2 = ue_2;
		this.ue_3 = ue_3;
		this.ue_4 = ue_4;
		this.ue_5 = ue_5;
		this.ue_6 = ue_6;
		this.ue_7 = ue_7;
		this.ue_8 = ue_8;
		this.ue_9 = ue_9;
		this.ue_10 = ue_10;
	}
	public Maquette(int id_maquette, String filiere_ma, String semestre,
			String ue_1, String ue_2, String ue_3, String ue_4, String ue_5,
			String ue_6, String ue_7, String ue_8, String ue_9, String ue_10) {
		super();
		this.id_maquette = id_maquette;
		this.filiere_ma = filiere_ma;
		this.semestre = semestre;
		this.ue_1 = ue_1;
		this.ue_2 = ue_2;
		this.ue_3 = ue_3;
		this.ue_4 = ue_4;
		this.ue_5 = ue_5;
		this.ue_6 = ue_6;
		this.ue_7 = ue_7;
		this.ue_8 = ue_8;
		this.ue_9 = ue_9;
		this.ue_10 = ue_10;
	}
	public int getId_maquette() {
		return id_maquette;
	}
	public void setId_maquette(int id_maquette) {
		this.id_maquette = id_maquette;
	}
	public String getFiliere_ma() {
		return filiere_ma;
	}
	public void setFiliere_ma(String filiere_ma) {
		this.filiere_ma = filiere_ma;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getUe_1() {
		return ue_1;
	}
	public void setUe_1(String ue_1) {
		this.ue_1 = ue_1;
	}
	public String getUe_2() {
		return ue_2;
	}
	public void setUe_2(String ue_2) {
		this.ue_2 = ue_2;
	}
	public String getUe_3() {
		return ue_3;
	}
	public void setUe_3(String ue_3) {
		this.ue_3 = ue_3;
	}
	public String getUe_4() {
		return ue_4;
	}
	public void setUe_4(String ue_4) {
		this.ue_4 = ue_4;
	}
	public String getUe_5() {
		return ue_5;
	}
	public void setUe_5(String ue_5) {
		this.ue_5 = ue_5;
	}
	public String getUe_6() {
		return ue_6;
	}
	public void setUe_6(String ue_6) {
		this.ue_6 = ue_6;
	}
	public String getUe_7() {
		return ue_7;
	}
	public void setUe_7(String ue_7) {
		this.ue_7 = ue_7;
	}
	public String getUe_8() {
		return ue_8;
	}
	public void setUe_8(String ue_8) {
		this.ue_8 = ue_8;
	}
	public String getUe_9() {
		return ue_9;
	}
	public void setUe_9(String ue_9) {
		this.ue_9 = ue_9;
	}
	public String getUe_10() {
		return ue_10;
	}
	public void setUe_10(String ue_10) {
		this.ue_10 = ue_10;
	}
	
}
