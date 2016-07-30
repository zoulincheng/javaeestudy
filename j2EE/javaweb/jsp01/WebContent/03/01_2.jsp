<%@page import="com.linzi.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("username") %>
<%
	//User u = (User)request.getAttribute("user");
	//User u = (User)session.getAttribute("user");
	User u = (User)application.getAttribute("user");
%>
<%
	if (u == null){
%>
	没有用户
<%
	}else{
%>
	<%=u.getUsername() %>
<%
	}
%>
</body>
</html>