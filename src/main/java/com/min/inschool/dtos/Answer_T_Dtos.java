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
	private Funtion_T_Dtos funtion_T_Dtos;
	private String a_option;
	
	
	
	
	public int getA_seq() {
		return a_seq;
	}

	public void setA_seq(int a_seq) {
		this.a_seq = a_seq;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getA_content1() {
		return a_content1;
	}

	public void setA_content1(String a_content1) {
		this.a_content1 = a_content1;
	}

	public String getA_content2() {
		return a_content2;
	}

	public void setA_content2(String a_content2) {
		this.a_content2 = a_content2;
	}

	public String getA_content3() {
		return a_content3;
	}

	public void setA_content3(String a_content3) {
		this.a_content3 = a_content3;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public Date getA_regdate() {
		return a_regdate;
	}

	public void setA_regdate(Date a_regdate) {
		this.a_regdate = a_regdate;
	}

	public int getA_recount() {
		return a_recount;
	}

	public void setA_recount(int a_recount) {
		this.a_recount = a_recount;
	}

	public String getA_unum() {
		return a_unum;
	}

	public void setA_unum(String a_unum) {
		this.a_unum = a_unum;
	}

	public String getA_comnum() {
		return a_comnum;
	}

	public void setA_comnum(String a_comnum) {
		this.a_comnum = a_comnum;
	}

	public String getA_boardname() {
		return a_boardname;
	}

	public void setA_boardname(String a_boardname) {
		this.a_boardname = a_boardname;
	}

	public int getA_ansnum() {
		return a_ansnum;
	}

	public void setA_ansnum(int a_ansnum) {
		this.a_ansnum = a_ansnum;
	}

	public int getA_ref() {
		return a_ref;
	}

	public void setA_ref(int a_ref) {
		this.a_ref = a_ref;
	}

	public int getA_step() {
		return a_step;
	}

	public void setA_step(int a_step) {
		this.a_step = a_step;
	}

	public int getA_depth() {
		return a_depth;
	}

	public void setA_depth(int a_depth) {
		this.a_depth = a_depth;
	}

	public String getV_oriname() {
		return v_oriname;
	}

	public void setV_oriname(String v_oriname) {
		this.v_oriname = v_oriname;
	}

	public String getV_type() {
		return v_type;
	}

	public void setV_type(String v_type) {
		this.v_type = v_type;
	}

	public int getV_filesize() {
		return v_filesize;
	}

	public void setV_filesize(int v_filesize) {
		this.v_filesize = v_filesize;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public int getImg_size() {
		return img_size;
	}

	public void setImg_size(int img_size) {
		this.img_size = img_size;
	}

	public Date getV_img_regdate() {
		return v_img_regdate;
	}

	public void setV_img_regdate(Date v_img_regdate) {
		this.v_img_regdate = v_img_regdate;
	}

	public Answer_T_Dtos() {

	}
	
	
	
	public Answer_T_Dtos(int a_seq, String a_title, String a_content1, String a_content2, String a_content3,
			String a_name, Date a_regdate, int a_recount, String a_unum, String a_comnum, String a_boardname,
			int a_ansnum, int a_ref, int a_step, int a_depth, String v_oriname, String v_type, int v_filesize,
			String img_name, int img_size, Date v_img_regdate, Funtion_T_Dtos funtion_T_Dtos, String a_option) {
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
		this.funtion_T_Dtos = funtion_T_Dtos;
		this.a_option = a_option;
	}

	public Funtion_T_Dtos getFuntion_T_Dtos() {
		return funtion_T_Dtos;
	}
	public void setFuntion_T_Dtos(Funtion_T_Dtos funtion_T_Dtos) {
		this.funtion_T_Dtos = funtion_T_Dtos;
	}
	public String getA_option() {
		return a_option;
	}
	public void setA_option(String a_option) {
		this.a_option = a_option;
	}
	@Override
	public String toString() {
		return "Answer_T_Dtos [a_seq=" + a_seq + ", a_title=" + a_title + ", a_content1=" + a_content1 + ", a_content2="
				+ a_content2 + ", a_content3=" + a_content3 + ", a_name=" + a_name + ", a_regdate=" + a_regdate
				+ ", a_recount=" + a_recount + ", a_unum=" + a_unum + ", a_comnum=" + a_comnum + ", a_boardname="
				+ a_boardname + ", a_ansnum=" + a_ansnum + ", a_ref=" + a_ref + ", a_step=" + a_step + ", a_depth="
				+ a_depth + ", v_oriname=" + v_oriname + ", v_type=" + v_type + ", v_filesize=" + v_filesize
				+ ", img_name=" + img_name + ", img_size=" + img_size + ", v_img_regdate=" + v_img_regdate
				+ ", funtion_T_Dtos=" + funtion_T_Dtos + ", a_option=" + a_option + "]";
	}
	
	
	
	
	
	
}
