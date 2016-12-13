package com.database.group6.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.database.group6.po.Professor;

public class ProfessorDao {
	
    public static int passwordModify(Connection con,Professor professor)throws Exception
    {
	String sql="update tb_teacher set TeacherPassword=? where TeacherNum=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, professor.getProfessorPassword());
	pstmt.setString(2, professor.getProfessorNum());
	return pstmt.executeUpdate();
	}

}