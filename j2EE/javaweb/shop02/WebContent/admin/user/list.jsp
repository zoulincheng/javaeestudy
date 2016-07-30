<%@page import="com.linzi.shop.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.linzi.shop.dao.DAOFactory"%>
<%@page import="com.linzi.shop.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	IUserDao userDao = DAOFactory.getUserDao();
	List<User> users = userDao.list();
	User loginUser = (User)session.getAttribute("loginUser");
%>
</head>
<body>
<jsp:include page="inc.jsp">
	<jsp:param value="列表" name="op"/>
</jsp:include>
<table align="center" border="1" width="800">
	<tr>
	<td>用户标识</td><td>用户名</td><td>用户密码</td><td>用户昵称</td>
	<td>用户类型</td><td>用户状态</td>
	<td>操作</td>
	</tr>
	<%
	for(User u: users){
	%>
	<tr>
	<td><%=u.getId() %></td>
	<td><%=u.getUsername() %></td>
	<td><%=u.getPassword() %></td>
	<td><%=u.getNickname() %></td>
	<td>
	<%
		if(u.getType() == 0){
	%>
		普通用户
		<%
		if (loginUser.getType()==1){
		%>
			<a href="setType.jsp?id=<%=u.getId()%>">&nbsp;设置管理员</a>
		<%
		}
		%>
		
	<%
		}else{
	%>
		管理员
		<%
		if (loginUser.getType()==1){
		%>
		<a href="setType.jsp?id=<%=u.getId()%>">&nbsp;取消管理员</a>
		<%
		}
		%>
		
	<%
		}
	%>
	</td>
	<td>
	<%
		if(u.getStatus() == 0){
	%>
		启用
		<%
		if (loginUser.getType() == 1){
		%>
		<a href="setStatus.jsp?id=<%=u.getId()%>">&nbsp;停用</a>		
		<%
		}
		%>
		
	<%
		}else{
	%>
		<span style='color:red'>停用</span>
		<%
			if (loginUser.getType()==1){
		%>
			<a href="setStatus.jsp?id=<%=u.getId()%>">&nbsp;启用</a>	
		<%
			}
		%>
		
	<%			
		}		
	%>
	</td>
	<td>
	<%
	if (loginUser.getType()==1){
	%>
		<a href="delete.jsp?id=<%=u.getId()%>">删除</a>&nbsp;&nbsp;<a href="updateInput.jsp?id=<%=u.getId()%>">更新 </a></td>
	<%
	}
	%>
	
	</tr>
	<%
	}
	%>
</table>
</body>
</html>