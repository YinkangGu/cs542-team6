package com.database.group6.po;

public class Stucourse {
	private String snum;
	private String cnum;
	public Stucourse() {
		super();
	}

	public Stucourse(String snum, String cnum) {
		super();
		this.snum = snum;
		this.cnum = cnum;	
	}
		
	public String getStudentsNum() {
		return snum;
	}
	public String getCoursesNum() {
		return cnum;
	}
	public void setCoursesNum(String cnum) {
		this.cnum = cnum;
	}
}

