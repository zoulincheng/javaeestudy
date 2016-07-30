 <%@page import="com.linzi.model.UserInit"%>
<%@page import="com.linzi.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp与java对象交互</title>
<%
	List<User> users = UserInit.initUser();
%>
</head>
<body>
<%=request.getParameter("username") %>
<table width = "700" align = "center" border="1">
<tr>
	<td>id</td><td>用户名称</td><td>用户昵称</td>
</tr>	
<%
	for(User u: users){
%>
	<tr>
	<td><%=u.getId() %></td><td><%=u.getUsername() %></td><td><%=u.getNickname()%></td>
	</tr>
<%
	}
%>	
</table>
</body>
</html>