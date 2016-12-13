package com.database.group6.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.database.group6.po.Student;

public class StudentDao {
	
    public static int passwordModify(Connection con,Student student)throws Exception
    {
	String sql="update tb_student set StudentPassword=? where StudentNum=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, student.getStudentPassword());
	pstmt.setString(2, student.getStudentNum());
	return pstmt.executeUpdate();
	}

}