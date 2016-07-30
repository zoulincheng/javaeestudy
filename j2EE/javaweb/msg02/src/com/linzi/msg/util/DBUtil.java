package com.linzi.msg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	public static Connection getConnection(){
//		Properties jdbcProp = PropertiesUtil.getJdbcProp();
////		String username = "itat";
////		String password = "itat123";
////		// "jdbc:mysql://localhost:3306/" + database;
////		String url = "jdbc:mysql://localhost:3306/itat_msg";
//		String username = jdbcProp.getProperty("username");
//		String password = jdbcProp.getProperty("password");
//		String url = jdbcProp.getProperty("url"); 
//		Connection con = null;
//		try {
//			con = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return con;
		
		Connection con = null;
		   
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/msg");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public static void close(Connection con){
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps){
		try {
			if (ps != null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
