<%@page import="com.linzi.shop.model.ShopException"%>
<%@page import="com.linzi.shop.model.User"%>
<%@page import="com.linzi.shop.dao.DAOFactory"%>
<%@page import="com.linzi.shop.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");
	try{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		IUserDao userDao = DAOFactory.getUserDao();
		User u = userDao.login(username, password);
		session.setAttribute("loginUser", u);
		response.sendRedirect(request.getContextPath()+"/admin/user/list.jsp");
	}catch(ShopException e){
%>
	<h2 style="color:red">发生错误： <%=e.getMessage() %></h2>
<%
	}
%>
</body>
</html>