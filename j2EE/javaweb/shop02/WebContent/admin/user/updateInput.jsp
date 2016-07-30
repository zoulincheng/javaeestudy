<%@page import="com.linzi.shop.model.User"%>
<%@page import="com.linzi.shop.dao.DAOFactory"%>
<%@page import="com.linzi.shop.dao.IUserDao"%>
<%@page import="com.linzi.shop.util.ValidateUtil"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户更新</title>
<%
	Class.forName("com.mysql.jdbc.Driver");		
	int userId = Integer.parseInt(request.getParameter("id"));
	IUserDao userDao = DAOFactory.getUserDao();
	User u = userDao.load(userId);
%>
</head>
<body>
<jsp:include page="inc.jsp">
	<jsp:param value="更新" name="op"/>
</jsp:include>
<%=request.getAttribute("error")
%>



<form action="update.jsp" method="post">
<table align="center" width="500" border="1">
<input type = "hidden" name="id" value="<%=u.getId()%>"/>	
	<tr>
		<td>用户名称：</td>
		<td>
		<%=u.getUsername() %>
		</td>
	</tr>
	
	<tr>
		<td>用户密码：</td>
		<td>
		<input type="password" name="password" value="<%=u.getPassword()%>"/>
		<%=ValidateUtil.showError(request, "password") %>
		</td>
	</tr>
	
	<tr>
		<td>用户昵称：</td>
		<td>
		<input type="text" name="nickname" value="<%=u.getNickname()%>"/>
		<%=ValidateUtil.showError(request, "nickname") %>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="更新用户"/>
			<input type="reset" value ="重置信息"/>
		</td>
	</tr>	
</table>	
</form>
</body>
</html>