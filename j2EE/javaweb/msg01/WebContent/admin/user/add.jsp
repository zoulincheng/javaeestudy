<%@page import="com.linzi.msg.util.ValidateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@page import="com.linzi.msg.dao.UserDao"%>
<%@page import="com.linzi.msg.model.MsgException"%>
<%@page import="com.linzi.msg.dao.DAOFactory"%>
<%@page import="com.linzi.msg.dao.IUserDao"%>
<%@page import="com.linzi.msg.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Class.forName("com.mysql.jdbc.Driver");	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	boolean validate = ValidateUtil.validateNull(request, new String[]{"username", "password", "nickname"});
		
	if (!validate){
%>
	<jsp:forward page="addInput.jsp"/>
<%

	}
		
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	user.setNickname(nickname);
	user.setType(0);
	user.setStatus(0);
	IUserDao userDao = DAOFactory.getUserDao();
	try {
		userDao.add(user);
		response.sendRedirect("list.jsp");
		return; 
	} catch (MsgException e) {
%>
	<h2 style="color:red">发生错误：<%=e.getMessage() %></h2>
<%	
	}
%>


