package com.min.inschool.dtos;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class cominfo_Dto implements Serializable {

	private static final long serialVersionUID = 6494104562467414156L;
	private int co_seq;
	private String co_name;
	private String co_title;
	private String co_location;
	private String co_jobtype;
	private String co_industry;
	private String co_jobcategory;
	private String co_exlevel;
	private String co_relevel;
	private String co_salary;
	private String co_podate;
	private String co_exdate;
	private String co_id;
	private String co_url;
	private Data co_regdate;
	public cominfo_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cominfo_Dto(int co_seq, String co_name, String co_title, String co_location, String co_jobtype,
			String co_industry, String co_jobcategory, String co_exlevel, String co_relevel, String co_salary,
			String co_podate, String co_exdate, String co_id, String co_url, Data co_regdate) {
		super();
		this.co_seq = co_seq;
		this.co_name = co_name;
		this.co_title = co_title;
		this.co_location = co_location;
		this.co_jobtype = co_jobtype;
		this.co_industry = co_industry;
		this.co_jobcategory = co_jobcategory;
		this.co_exlevel = co_exlevel;
		this.co_relevel = co_relevel;
		this.co_salary = co_salary;
		this.co_podate = co_podate;
		this.co_exdate = co_exdate;
		this.co_id = co_id;
		this.co_url = co_url;
		this.co_regdate = co_regdate;
	}
	@Override
	public String toString() {
		return "cominfo_Dto [co_seq=" + co_seq + ", co_name=" + co_name + ", co_title=" + co_title + ", co_location="
				+ co_location + ", co_jobtype=" + co_jobtype + ", co_industry=" + co_industry + ", co_jobcategory="
				+ co_jobcategory + ", co_exlevel=" + co_exlevel + ", co_relevel=" + co_relevel + ", co_salary="
				+ co_salary + ", co_podate=" + co_podate + ", co_exdate=" + co_exdate + ", co_id=" + co_id + ", co_url="
				+ co_url + ", co_regdate=" + co_regdate + "]";
	}
	public int getCo_seq() {
		return co_seq;
	}
	public void setCo_seq(int co_seq) {
		this.co_seq = co_seq;
	}
	public String getCo_name() {
		return co_name;
	}
	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}
	public String getCo_title() {
		return co_title;
	}
	public void setCo_title(String co_title) {
		this.co_title = co_title;
	}
	public String getCo_location() {
		return co_location;
	}
	public void setCo_location(String co_location) {
		this.co_location = co_location;
	}
	public String getCo_jobtype() {
		return co_jobtype;
	}
	public void setCo_jobtype(String co_jobtype) {
		this.co_jobtype = co_jobtype;
	}
	public String getCo_industry() {
		return co_industry;
	}
	public void setCo_industry(String co_industry) {
		this.co_industry = co_industry;
	}
	public String getCo_jobcategory() {
		return co_jobcategory;
	}
	public void setCo_jobcategory(String co_jobcategory) {
		this.co_jobcategory = co_jobcategory;
	}
	public String getCo_exlevel() {
		return co_exlevel;
	}
	public void setCo_exlevel(String co_exlevel) {
		this.co_exlevel = co_exlevel;
	}
	public String getCo_relevel() {
		return co_relevel;
	}
	public void setCo_relevel(String co_relevel) {
		this.co_relevel = co_relevel;
	}
	public String getCo_salary() {
		return co_salary;
	}
	public void setCo_salary(String co_salary) {
		this.co_salary = co_salary;
	}
	public String getCo_podate() {
		return co_podate;
	}
	public void setCo_podate(String co_podate) {
		this.co_podate = co_podate;
	}
	public String getCo_exdate() {
		return co_exdate;
	}
	public void setCo_exdate(String co_exdate) {
		this.co_exdate = co_exdate;
	}
	public String getCo_id() {
		return co_id;
	}
	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}
	public String getCo_url() {
		return co_url;
	}
	public void setCo_url(String co_url) {
		this.co_url = co_url;
	}
	public Data getCo_regdate() {
		return co_regdate;
	}
	public void setCo_regdate(Data co_regdate) {
		this.co_regdate = co_regdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
