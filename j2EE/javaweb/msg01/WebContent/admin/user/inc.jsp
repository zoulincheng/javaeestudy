<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/inc/top.jsp"/>
<h2 align="center">用户<%=request.getParameter("op") %>功能</h2>
<a href="addInput.jsp">添加用户</a>&nbsp;
<a href="list.jsp">用户列表</a>&nbsp;
<hr/>
