<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/inc/top.jsp"></jsp:include>
<h2 align="center">用户登录</h2>
<hr/>
<form action="login.jsp" method="post">
用户名称：<input type="text" name="username" style="width:200px""/><br/>
用户密码：<input type="password" name="password" style="width:200px"/><br/>
<input type="submit" value="用户登录"/>

</form>
</body>
</html>