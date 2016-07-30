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
<%--response.sendRedirect跳转之后依然会执行剩下的代码才进行跳转 --%>
<%
	User u = null;
	int id = 10;
	if (id == 10){
		response.sendRedirect("03.jsp?username=张三");
		return; 
	} else {
		u.setId(id);
	}
%>
</body>
</html>