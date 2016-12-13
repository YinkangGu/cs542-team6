package com.database.group6.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.database.group6.po.Administrator;

public class AdministratorDao {
	public static int passwordModify(Connection con,Administrator adminstrator)throws Exception
    {
	String sql="update tb_manager set ManagerPassword=? where ManagerNum=? ";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, adminstrator.getManagerPassword());
	pstmt.setString(2, adminstrator.getManagerNum());
	return pstmt.executeUpdate();
	}
}
