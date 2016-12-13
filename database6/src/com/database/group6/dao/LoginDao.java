package com.database.group6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.database.group6.po.Administrator;
import com.database.group6.po.Professor;
import com.database.group6.po.Student;

public class LoginDao {		
        public static Student studentlogin(Connection con,Student student)throws Exception
        {
        	  Student resultStu=null;
	          String sql="select * from tb_student where StudentNum=? and StudentPassword=?" ;
              PreparedStatement pstmt=con.prepareStatement(sql);
              pstmt.setString(1,student.getStudentNum());
              pstmt.setString(2,student.getStudentPassword());
              ResultSet rs=pstmt.executeQuery();
              if(rs.next()){
            		resultStu=new Student();
            		resultStu.setStudentNum(rs.getString("StudentNum"));
            		resultStu.setStudentPassword(rs.getString("StudentPassword"));	
            	}
              return resultStu;    
	}
        
        public static ResultSet professorlogin(Connection con,Professor professor)throws Exception
        {
	          String sql="select * from tb_teacher where TeacherNum=? and TeacherPassword=?" ;
              PreparedStatement pstmt=con.prepareStatement(sql);
              pstmt.setString(1,professor.getProfessorNum());
              pstmt.setString(2,professor.getProfessorPassword());
              return pstmt.executeQuery();
	}
            
        public static ResultSet administratorlogin(Connection con, Administrator administrator)throws Exception
  {
	           String sql="select * from tb_manager where ManagerNum=? and ManagerPassword=?";
               PreparedStatement pstmt=con.prepareStatement(sql);
               pstmt.setString(1,administrator.getManagerNum());
               pstmt.setString(2,administrator.getManagerPassword());
               return pstmt.executeQuery();
	}
}