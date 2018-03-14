package com.min.inschool.dtos;

import java.io.Serializable;
import java.sql.Date;

public class Answer_T_Dtos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1395142636706501069L;
	
	
	private int a_seq;
	private String a_title;
	private String a_content1;
	private String a_content2;
	private String a_content3;
	private String a_name;
	private Date a_regdate;
	private int a_recount;
	private String a_unum;
	private String a_comnum;
	private String a_boardname;
	private int a_ansnum;
	private int a_ref;
	private int a_step;
	private int a_depth;
	private String v_oriname;
	private String v_type;
	private	int v_filesize;
	private String img_name;
	private int img_size;
	private Date v_img_regdate;
	
	
	public Answer_T_Dtos() {
		
	}
	
	public Answer_T_Dtos(int a_seq, String a_title, String a_content1, String a_content2, String a_content3,
			String a_name, Date a_regdate, int a_recount, String a_unum, String a_comnum, String a_boardname,
			int a_ansnum, int a_ref, int a_step, int a_depth, String v_oriname, String v_type, int v_filesize,
			String img_name, int img_size, Date v_img_regdate) {
		super();
		this.a_seq = a_seq;
		this.a_title = a_title;
		this.a_content1 = a_content1;
		this.a_content2 = a_content2;
		this.a_content3 = a_content3;
		this.a_name = a_name;
		this.a_regdate = a_regdate;
		this.a_recount = a_recount;
		this.a_unum = a_unum;
		this.a_comnum = a_comnum;
		this.a_boardname = a_boardname;
		this.a_ansnum = a_ansnum;
		this.a_ref = a_ref;
		this.a_step = a_step;
		this.a_depth = a_depth;
		this.v_oriname = v_oriname;
		this.v_type = v_type;
		this.v_filesize = v_filesize;
		this.img_name = img_name;
		this.img_size = img_size;
		this.v_img_regdate = v_img_regdate;
	}

	@Override
	public String toString() {
		return "Answer_T_Dtos [a_seq=" + a_seq + ", a_title=" + a_title + ", a_content1=" + a_content1 + ", a_content2="
				+ a_content2 + ", a_content3=" + a_content3 + ", a_name=" + a_name + ", a_regdate=" + a_regdate
				+ ", a_recount=" + a_recount + ", a_unum=" + a_unum + ", a_comnum=" + a_comnum + ", a_boardname="
				+ a_boardname + ", a_ansnum=" + a_ansnum + ", a_ref=" + a_ref + ", a_step=" + a_step + ", a_depth="
				+ a_depth + ", v_oriname=" + v_oriname + ", v_type=" + v_type + ", v_filesize=" + v_filesize
				+ ", img_name=" + img_name + ", img_size=" + img_size + ", v_img_regdate=" + v_img_regdate + "]";
	}
	
	
	
	
	
	
}
