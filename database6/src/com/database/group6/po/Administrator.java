package com.database.group6.po;

public class Administrator {
	private String anum;
	private String aname;
	private String asex;
	private String apassword;
    public Administrator(){
    	super();	
	}
	public Administrator(String anum, String apassword){
		super();
		this.apassword = apassword;
		this.anum = anum;
	}
	public Administrator(String apassword, String anum, String asex){
		super();
		this.apassword = apassword;
		this.anum = anum;
		this.asex = asex;
	}
	public String getManagerNum() {
		return anum;
	}
	public String getManagerName() {
		return aname;
	}
	public String getManagerSex() {
		return asex;
	}
	public String getManagerPassword() {
		return apassword;
	}
	public void setManagerPassword(String apassword) {
		this.apassword = apassword;
	}

}
