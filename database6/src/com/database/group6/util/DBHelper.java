package com.database.group6.util;

import java.sql.Connection;  
import java.sql.DriverManager;  
  
public class DBHelper {  
    public static final String url = "jdbc:mysql://localhost:3306/project6";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "595716"; 
    
    public Connection getCon() throws Exception {
		Class.forName(name);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
    
    public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public static void main(String[] args) {
		DBHelper dbhelper = new DBHelper();
		try {
			dbhelper.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper(String sql) {  
        try {  
            Class.forName(name); 
            conn = DriverManager.getConnection(url, user, password); 
            pst = conn.prepareStatement(sql); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    } 
 */ 