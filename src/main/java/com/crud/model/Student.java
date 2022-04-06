package com.crud.model;

import java.util.Date;

public class Student {

	private int rollnum;
	private String studname;
	private Date DOB;
	
	public Student(int rollnum, String studname, Date DOB) {
		this.rollnum = rollnum;
		this.studname = studname;
		this.DOB = DOB;
	}
	public int getRollnum() {
		return rollnum;
	}
	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}
	
	
}
