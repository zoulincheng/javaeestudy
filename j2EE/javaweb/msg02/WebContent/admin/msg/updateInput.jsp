<%@page import="com.linzi.msg.model.Message"%>
<%@page import="com.linzi.msg.dao.DAOFactory"%>
<%@page import="com.linzi.msg.util.ValidateUtil"%>
<%@page import="com.linzi.msg.dao.IMessageDao"%>
<%@page import="com.linzi.msg.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言更新</title>
 <%
	int id = Integer.parseInt(request.getParameter("id"));
	IMessageDao msgDao = DAOFactory.getMessageDao();
	Message msg = msgDao.load(id);
	boolean flag = ValidateUtil.checkAdminOrSelf(session, msg.getUserId());
	if (!flag){
		response.sendRedirect(request.getContextPath()+ "/msg/list.jsp");
		return;
	}

 %>
</head>

<body>
<jsp:include page="/msg/inc.jsp">
	<jsp:param value="更新" name="op"/>
</jsp:include>
<form action="update.jsp" method="post">
<input type="hidden" name="id" value="<%=msg.getId()%>"/>
<table width="800" align="center" border="1">
	<tr>
	<td width="130">标题</td><td><input type="text" name="title" size="80" value="<%=msg.getTitle()%>"></td>
	</tr>
	<tr>
	<td colspan="2">内容</td>
	</tr>
	<tr>
	<td colspan="2">
	<textarea rows="20" cols="100 " name="content">
	<%=msg.getContent() %>
	</textarea>
	</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
		<input type="submit" value="更新留言"/><input type="reset"/>
	</td>
	</tr>
</table>
</form>
</body>
</html>