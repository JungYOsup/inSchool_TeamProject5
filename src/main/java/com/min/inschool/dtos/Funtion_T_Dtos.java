package com.min.inschool.dtos;

import java.io.Serializable;

public class Funtion_T_Dtos implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7013870536170803957L;
	
	private int f_like;
	private String f_save;
	private String f_unum;
	private String f_comnum;
	private int a_seq;
		
	
	
	public Funtion_T_Dtos() {
	}
	
	
	public Funtion_T_Dtos(int f_like, String f_save, String f_unum, String f_comnum, int a_seq) {
		super();
		this.f_like = f_like;
		this.f_save = f_save;
		this.f_unum = f_unum;
		this.f_comnum = f_comnum;
		this.a_seq = a_seq;
	}
	
	public int getF_like() {
		return f_like;
	}
	public void setF_like(int f_like) {
		this.f_like = f_like;
	}
	public String getF_save() {
		return f_save;
	}
	public void setF_save(String f_save) {
		this.f_save = f_save;
	}
	public String getF_unum() {
		return f_unum;
	}
	public void setF_unum(String f_unum) {
		this.f_unum = f_unum;
	}
	public String getF_comnum() {
		return f_comnum;
	}
	public void setF_comnum(String f_comnum) {
		this.f_comnum = f_comnum;
	}
	public int getA_seq() {
		return a_seq;
	}
	public void setA_seq(int a_seq) {
		this.a_seq = a_seq;
	}
	@Override
	public String toString() {
		return "Funtion_T_Dtos [f_like=" + f_like + ", f_save=" + f_save + ", f_unum=" + f_unum + ", f_comnum="
				+ f_comnum + ", a_seq=" + a_seq + "]";
	}
	
	
	
	
	
	
	

}
