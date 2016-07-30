<%@page import="com.linzi.shop.util.ValidateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.*"%>
<%@page import="com.linzi.shop.dao.UserDao"%>
<%@page import="com.linzi.shop.model.ShopException"%>
<%@page import="com.linzi.shop.dao.DAOFactory"%>
<%@page import="com.linzi.shop.dao.IUserDao"%>
<%@page import="com.linzi.shop.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Class.forName("com.mysql.jdbc.Driver");		
	int userId = Integer.parseInt(request.getParameter("id"));
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	boolean validate = ValidateUtil.validateNull(request, new String[]{"password", "nickname"});
		
	if (!validate){
%>
	<jsp:forward page="updateInput.jsp"/>
<%

	}
	IUserDao userDao = DAOFactory.getUserDao();	
	User user = userDao.load(userId);
	user.setPassword(password);
	user.setNickname(nickname);
	try {
		userDao.update(user);
		response.sendRedirect("list.jsp");
		return; 
	} catch (ShopException e) {
%>
	<h2 style="color:red">发生错误：<%=e.getMessage() %></h2>
<%	
	}
%>


