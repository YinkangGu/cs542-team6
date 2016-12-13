package com.database.group6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.group6.po.Course;
import com.database.group6.util.StringHelper;

public class CourseDao {
	public static int courseAdd(Connection con,Course course)throws Exception{
		String sql="insert into tb_course value(?,?,?,?,?,?,'TBA')";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setString(1,course.getCourseNum());
		pstmt.setString(2,course.getCourseName());
		pstmt.setString(3,course.getCourseTeacherNum());
		pstmt.setString(4,course.getCourseMajorNum());
		pstmt.setDouble(5,course.getCourseCredit());
		pstmt.setString(6,course.getCourseTime());
		return pstmt.executeUpdate();
	}
	public static ResultSet courseList(Connection con,Course course) throws SQLException{
		StringBuffer sb=new StringBuffer("select * from tb_course");
		if(StringHelper.isNotEmpty(course.getCourseNum())){
			sb.append(" or CourseNum like '%"+course.getCourseNum()+"%'");
		}
		if(StringHelper.isNotEmpty(course.getCourseName())){
			sb.append(" or CourseName like '%"+course.getCourseName()+"%'");
		}
		if(StringHelper.isNotEmpty(course.getCourseTeacherNum())){
			sb.append(" or TeacherNum like '%"+course.getCourseTeacherNum()+"%'");
		}
		if(StringHelper.isNotEmpty(course.getCourseMajorNum())){
			sb.append(" or MajorNum like '%"+course.getCourseMajorNum()+"%'");
		}
		if(StringHelper.isNotEmpty(String.valueOf(course.getCourseCredit()))){
			sb.append(" or CourseCredit like '%"+course.getCourseCredit()+"%'");
		}
		if(StringHelper.isNotEmpty(course.getCourseTime())){
			sb.append(" or CourseTime like '%"+course.getCourseTime()+"%'");
		}
        PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("or", "where"));
        return pstmt.executeQuery();
		}
	public static int courseDelete(Connection con,String CourseNum)throws Exception{
		String sql="delete from tb_course where CourseNum=?";
		PreparedStatement  pstmt=con.prepareStatement(sql);
		pstmt.setString(1, CourseNum);
		return pstmt.executeUpdate();
	}
	public static int courseModify(Connection con,Course course)throws Exception{
		String sql="update tb_course set CourseName=?,TeacherNum=?,MajorNum=?,CourseCredit=?,CourseTime=? where CourseNum=? ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, course.getCourseName());
		pstmt.setString(2, course.getCourseTeacherNum());
		pstmt.setString(3, course.getCourseMajorNum());
		pstmt.setDouble(4,course.getCourseCredit());
		pstmt.setString(5, course.getCourseTime());
		pstmt.setString(6, course.getCourseNum());
		return pstmt.executeUpdate();	
	}
	public static ResultSet allcourseList(Connection con,Course course) throws SQLException{
		String sql="select * from tb_course";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	public static ResultSet professorList(Connection con,String TeacherNum) throws SQLException{
		String sql="select * from tb_course where TeacherNum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, TeacherNum);
		return pstmt.executeQuery();
	}
	public static int courseDescModify(Connection con, Course course) throws SQLException{
		String sql="update tb_course set CourseDesc=? where CourseNum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, course.getCourseDesc());
		pstmt.setString(2, course.getCourseNum());
		return pstmt.executeUpdate();		
	}
	public static ResultSet courseDesc(Connection con, String CourseNum) throws SQLException{
		String sql="select CourseDesc from tb_course where CourseNum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, CourseNum);
		return pstmt.executeQuery();		
	}
	
}

