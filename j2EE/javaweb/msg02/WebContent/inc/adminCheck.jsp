<%@page import="com.linzi.msg.model.MsgException"%>
<%@page import="com.linzi.msg.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	User loginUser = (User)session.getAttribute("loginUser");
	if (loginUser.getType() != 1){
		throw new MsgException("没有权限操作");
	}
%>