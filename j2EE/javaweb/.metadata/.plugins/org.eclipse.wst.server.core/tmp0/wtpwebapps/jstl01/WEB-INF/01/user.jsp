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
${u.nickname}--${u.age}--${u.name}
<c:if test="${u.age gt 18 }">成年了</c:if>
<c:if test="${empty aa }"> 没有Aa属性</c:if>
<c:if test="${not empty u }">u not empty</c:if>
<c:choose>
	<c:when test="${age eq 11 }">11岁</c:when>
	<c:when test="${age le 18 }">未成年</c:when>
	<c:otherwise> 成年了</c:otherwise>
</c:choose>
<table align="center"  width="900" cellpadding="0" cellspacing="0">
	<tr>
	<td>用户名称</td><td>用户昵称</td><td>用户年龄</td>
	</tr>
	<c:forEach var="user" items="${users}" varStatus="s">
		<tr><td>${user.name}</td><td>${user.nickname}--${s.index }</td>
		<td>
		<c:if test="${user.age gt 25 }">${user.age}</c:if> 
		<c:if test="${user.age le 25 }">未成年</c:if>
		</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>