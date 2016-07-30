<%@page import="com.linzi.msg.model.User"%>
<%@page import="com.linzi.msg.dao.DAOFactory"%>
<%@page import="com.linzi.msg.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/inc/adminCheck.jsp" %>
<%
	Class.forName("com.mysql.jdbc.Driver");	
	int userId = Integer.parseInt(request.getParameter("id"));
	IUserDao userDao = DAOFactory.getUserDao();
	User u = userDao.load(userId);
	if (u.getStatus() == 0){
		u.setStatus(1);
	} else {
		u.setStatus(0);
	}
	userDao.update(u);
	response.sendRedirect("list.jsp");
%>
</body>
</html>