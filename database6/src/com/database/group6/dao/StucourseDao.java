package com.database.group6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.database.group6.po.Stucourse;

public class StucourseDao {
	public static int stucourseAdd(Connection con,Stucourse stucourse)throws Exception{
		String sql="insert into tb_stucourse value(?,?)";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setString(1,stucourse.getStudentsNum());
		pstmt.setString(2,stucourse.getCoursesNum());
		return pstmt.executeUpdate();
	}
	public static ResultSet stucourseList(Connection con,String StudentNum)throws Exception{
		String sql="select * from tb_stucourse s,tb_course c where s.StudentNum=? and s.CourseNum=c.CourseNum";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,StudentNum);
		return pstmt.executeQuery();
	}
	public static ResultSet coursesList(Connection con,String CourseNum)throws Exception{
		String sql="select * from tb_stucourse where CourseNum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,CourseNum);
		return pstmt.executeQuery();
	}
	public static int stucourseDelete(Connection con,Stucourse StudentNum)throws Exception{
		String sql="delete from tb_stucourse where StudentNum=? and CourseNum=?";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setString(1,StudentNum.getStudentsNum());
		pstmt.setString(2,StudentNum.getCoursesNum());
		return pstmt.executeUpdate();
	}

}
