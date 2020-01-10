package com.min.inschool.dtos;

import java.io.Serializable;
import java.sql.Date;

public class Join_T_Dtos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2767769103682671934L;
	
	private int j_seq;
	private String j_id;
	private String j_pass;
	private String j_name;
	private String j_addr;
	private String j_deaddr;
	private String j_post;
	private String j_birth;
	private String j_tel;
	private String j_sex;
	private String j_job;
	private String j_comtype;
	private String j_comnumsal;
	private String j_comboss;
	private String j_email;
	private String j_unum;
	private String j_comnum;
	private String j_grade;
	private String j_delflag;
	private Date j_regdate;
		
	
	public Join_T_Dtos() {
		
		
	}
	
	
	public Join_T_Dtos(int j_seq, String j_id, String j_pass, String j_name, String j_addr, String j_deaddr,
			String j_post, String j_birth, String j_tel, String j_sex, String j_job, String j_comtype,
			String j_comnumsal, String j_comboss, String j_email, String j_unum, String j_comnum, String j_grade,
			String j_delflag, Date j_regdate) {
		super();
		this.j_seq = j_seq;
		this.j_id = j_id;
		this.j_pass = j_pass;
		this.j_name = j_name;
		this.j_addr = j_addr;
		this.j_deaddr = j_deaddr;
		this.j_post = j_post;
		this.j_birth = j_birth;
		this.j_tel = j_tel;
		this.j_sex = j_sex;
		this.j_job = j_job;
		this.j_comtype = j_comtype;
		this.j_comnumsal = j_comnumsal;
		this.j_comboss = j_comboss;
		this.j_email = j_email;
		this.j_unum = j_unum;
		this.j_comnum = j_comnum;
		this.j_grade = j_grade;
		this.j_delflag = j_delflag;
		this.j_regdate = j_regdate;
	}
	
	
	public int getJ_seq() {
		return j_seq;
	}
	public void setJ_seq(int j_seq) {
		this.j_seq = j_seq;
	}
	public String getJ_id() {
		return j_id;
	}
	public void setJ_id(String j_id) {
		this.j_id = j_id;
	}
	public String getJ_pass() {
		return j_pass;
	}
	public void setJ_pass(String j_pass) {
		this.j_pass = j_pass;
	}
	public String getJ_name() {
		return j_name;
	}
	public void setJ_name(String j_name) {
		this.j_name = j_name;
	}
	public String getJ_addr() {
		return j_addr;
	}
	public void setJ_addr(String j_addr) {
		this.j_addr = j_addr;
	}
	public String getJ_deaddr() {
		return j_deaddr;
	}
	public void setJ_deaddr(String j_deaddr) {
		this.j_deaddr = j_deaddr;
	}
	public String getJ_post() {
		return j_post;
	}
	public void setJ_post(String j_post) {
		this.j_post = j_post;
	}
	public String getJ_birth() {
		return j_birth;
	}
	public void setJ_birth(String j_birth) {
		this.j_birth = j_birth;
	}
	public String getJ_tel() {
		return j_tel;
	}
	public void setJ_tel(String j_tel) {
		this.j_tel = j_tel;
	}
	public String getJ_sex() {
		return j_sex;
	}
	public void setJ_sex(String j_sex) {
		this.j_sex = j_sex;
	}
	public String getJ_job() {
		return j_job;
	}
	public void setJ_job(String j_job) {
		this.j_job = j_job;
	}
	public String getJ_comtype() {
		return j_comtype;
	}
	public void setJ_comtype(String j_comtype) {
		this.j_comtype = j_comtype;
	}
	public String getJ_comnumsal() {
		return j_comnumsal;
	}
	public void setJ_comnumsal(String j_comnumsal) {
		this.j_comnumsal = j_comnumsal;
	}
	public String getJ_comboss() {
		return j_comboss;
	}
	public void setJ_comboss(String j_comboss) {
		this.j_comboss = j_comboss;
	}
	public String getJ_email() {
		return j_email;
	}
	public void setJ_email(String j_email) {
		this.j_email = j_email;
	}
	public String getJ_unum() {
		return j_unum;
	}
	public void setJ_unum(String j_unum) {
		this.j_unum = j_unum;
	}
	public String getJ_comnum() {
		return j_comnum;
	}
	public void setJ_comnum(String j_comnum) {
		this.j_comnum = j_comnum;
	}
	public String getJ_grade() {
		return j_grade;
	}
	public void setJ_grade(String j_grade) {
		this.j_grade = j_grade;
	}
	public String getJ_delflag() {
		return j_delflag;
	}
	public void setJ_delflag(String j_delflag) {
		this.j_delflag = j_delflag;
	}
	public Date getJ_regdate() {
		return j_regdate;
	}
	public void setJ_regdate(Date j_regdate) {
		this.j_regdate = j_regdate;
	}
	
	@Override
	public String toString() {
		return "Join_T_Dtos [j_seq=" + j_seq + ", j_id=" + j_id + ", j_pass=" + j_pass + ", j_name=" + j_name
				+ ", j_addr=" + j_addr + ", j_deaddr=" + j_deaddr + ", j_post=" + j_post + ", j_birth=" + j_birth
				+ ", j_tel=" + j_tel + ", j_sex=" + j_sex + ", j_job=" + j_job + ", j_comtype=" + j_comtype
				+ ", j_comnumsal=" + j_comnumsal + ", j_comboss=" + j_comboss + ", j_email=" + j_email + ", j_unum="
				+ j_unum + ", j_comnum=" + j_comnum + ", j_grade=" + j_grade + ", j_delflag=" + j_delflag
				+ ", j_regdate=" + j_regdate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
