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
<a href = "01_2.jsp?username=xxxx">01_2.jsp</a>
<%
	User u = new User(12, "abc", "aa");
	pageContext.setAttribute("user", u);
%>
<%
	User uu = (User)pageContext.getAttribute("user");
%>
<%=uu.getId() %>
<jsp:forward page="01_2.jsp"></jsp:forward>
</body>
</html>