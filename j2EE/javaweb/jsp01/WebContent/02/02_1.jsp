<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "../01/03.jsp">访问03页面(../01/03.jsp)</a><br/>
<img src="../img/Icon_1.png"/>
<img src="../img/hudie.jpg"/><br/>
<%=application.getRealPath("/") %><br/>
<a href="<%=request.getContextPath() %>/01/03.jsp">访问03页面（绝对路径：/<%=request.getContextPath() %>>）</a>
</body>
</html>