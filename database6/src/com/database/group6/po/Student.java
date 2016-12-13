package com.database.group6.po;

public class Student {
	private String snum;
	private String smnum;
	private String sname;
	private String ssex;
	private String spassword;
	public Student(){
		super();
	}
	public Student(String snum, String spassword){
		super();
		this.spassword = spassword;
		this.snum = snum;
	}
	public Student(String spassword, String snum, String ssex){
		super();
		this.spassword = spassword;
		this.snum = snum;
		this.ssex = ssex;
	}
	public String getStudentNum() {
		return snum;
	}
	public void setStudentNum(String snum) {
		this.snum = snum;
	}
	public String getStudentMajorNum() {
		return smnum;
	}
	public String getStudentName() {
		return sname;
	}
	public String getStudentSex() {
		return ssex;
	}
	public String getStudentPassword() {
		return spassword;
	}
	public void setStudentPassword(String spassword) {
		this.spassword = spassword;
	}
}
