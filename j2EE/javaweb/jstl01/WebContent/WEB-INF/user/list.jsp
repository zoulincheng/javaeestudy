<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border-bottom: 1px solid #000;
		border-right: 1px solid #000;
	}
	table td{
		border-top: 1px solid #000;
		border-left: 1px solid #000;
		padding: 5px;
	}
</style>
</head>
<body>
<a href="register.do">用户注册</a>
<table width="700" cellpadding="0" cellspacing="0">
	<tr><td>用户名</td><td>用户昵称</td><td>用户年龄</td></tr>
	<c:if test="${empty users }">
		<tr><td colspan="3">没有用户</td></tr>
	</c:if>
	<c:if test="${not empty users }">
		<c:forEach var="user" items="${users}">
			<tr><td>${user.name }</td><td>${user.nickname }</td><td>${user.age }</td></tr>
		</c:forEach>	
	</c:if>

</table>
</body>
</html>