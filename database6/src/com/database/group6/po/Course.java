package com.database.group6.po;

public class Course {
	private String cnum;
	private String cname;
	private String tnum;
	private String mnum;
	private double ccredit;
	private String ctime;
	private String cdesc;
	
	public Course() {
		super();
	}
	public Course(String cdesc,String cnum) {
		super();
		this.cnum = cnum;
		this.cdesc = cdesc;
	}

	public Course(String cnum, String cname, String tnum, String mnum, double ccredit, String ctime) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.tnum = tnum;
		this.mnum = mnum;
		this.ccredit = ccredit;
		this.ctime = ctime;
	}
	public Course(String cname, String tnum, String mnum, double ccredit, String ctime,String cnum) {
		super();
		this.cnum = cnum;
		this.cname = cname;
		this.tnum = tnum;
		this.mnum = mnum;
		this.ccredit = ccredit;
		this.ctime = ctime;
	}
	
	public String getCourseNum() {
		return cnum;
	}
	public void setCourseNum(String cnum) {
		this.cnum = cnum;
	}
	public String getCourseName() {
		return cname;
	}
	public void setCourseName(String cname) {
		this.cname = cname;
	}
	public String getCourseTeacherNum() {
		return tnum;
	}
	public void setCourseTeacherNum(String tnum) {
		this.tnum = tnum;
	}
	public String getCourseMajorNum() {
		return mnum;
	}
	public void setCourseMajorNum(String mnum) {
		this.mnum = mnum;
	}
	public double getCourseCredit() {
		return ccredit;
	}
	public void setCourseCredit(double ccredit) {
		this.ccredit = ccredit;
	}
	public String getCourseTime() {
		return ctime;
	}
	public void setCourseTime(String ctime) {
		this.ctime = ctime;
	}
	public String getCourseDesc() {
		return cdesc;
	}
	public void setCourseDesc(String cdesc) {
		this.cdesc = cdesc;
	}

}
