package com.min.inschool.dtos;

import java.io.Serializable;
import java.sql.Date;

public class REPLY_T_Dtos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393265135421053001L;
	
	private Date r_regdate;
	private int r_seq;
	private String r_content;
	private int r_ref;
	private int r_depth;
	private int a_seq;
	private String r_unum;
	private String r_boardname;
	
	
	public REPLY_T_Dtos() {
		
	}
	
	
	public REPLY_T_Dtos(Date r_regdate, int r_seq, String r_content, int r_ref, int r_depth, int a_seq, String r_unum,
			String r_boardname) {
		super();
		this.r_regdate = r_regdate;
		this.r_seq = r_seq;
		this.r_content = r_content;
		this.r_ref = r_ref;
		this.r_depth = r_depth;
		this.a_seq = a_seq;
		this.r_unum = r_unum;
		this.r_boardname = r_boardname;
	}
	
	
	public Date getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(Date r_regdate) {
		this.r_regdate = r_regdate;
	}
	public int getR_seq() {
		return r_seq;
	}
	public void setR_seq(int r_seq) {
		this.r_seq = r_seq;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public int getR_ref() {
		return r_ref;
	}
	public void setR_ref(int r_ref) {
		this.r_ref = r_ref;
	}
	public int getR_depth() {
		return r_depth;
	}
	public void setR_depth(int r_depth) {
		this.r_depth = r_depth;
	}
	public int getA_seq() {
		return a_seq;
	}
	public void setA_seq(int a_seq) {
		this.a_seq = a_seq;
	}
	public String getR_unum() {
		return r_unum;
	}
	public void setR_unum(String r_unum) {
		this.r_unum = r_unum;
	}
	public String getR_boardname() {
		return r_boardname;
	}
	public void setR_boardname(String r_boardname) {
		this.r_boardname = r_boardname;
	}
	@Override
	public String toString() {
		return "REPLY_T_Dtos [r_regdate=" + r_regdate + ", r_seq=" + r_seq + ", r_content=" + r_content + ", r_ref="
				+ r_ref + ", r_depth=" + r_depth + ", a_seq=" + a_seq + ", r_unum=" + r_unum + ", r_boardname="
				+ r_boardname + "]";
	}
	
	
	

}
