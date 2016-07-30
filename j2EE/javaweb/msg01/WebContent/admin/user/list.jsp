<%@page import="com.linzi.msg.model.SystemContext"%>
<%@page import="com.linzi.msg.model.Pager"%>
<%@page import="com.linzi.msg.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.linzi.msg.dao.DAOFactory"%>
<%@page import="com.linzi.msg.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	
	String con = request.getParameter("con");
	IUserDao userDao = DAOFactory.getUserDao();

	if (con == null)
		con="";
	
	//List<User> users = userDao.list(con);
	Pager<User> pages = userDao.list(con);
	List<User> users = pages.getDatas(); 
	User loginUser = (User)session.getAttribute("loginUser");
%>
</head>
<body>
<jsp:include page="inc.jsp">
	<jsp:param value="列表" name="op"/>
</jsp:include>
<table align="center" border="1" width="1000">
	<tr>
		<td colspan="7">
			<form action="list.jsp">
			输入用户名或者昵称：<input type="text" name="con" value="<%=con %>"/>
			<input type="submit" value="查询"/>
			</form>
		</td>
	</tr>
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
	
	<tr>
		<td colspan="7">
		一共有：<%=pages.getTotalRecord() %>条记录，当前是第<%=pages.getPageIndex() %>页，每页显示<%=pages.getPageSize() %>条记录
		</td>
	</tr>
	
	<tr>
		<td colspan="7" style="font-size: 12px">
		<%
			if (pages.getPageIndex() > 1){
		%>
			<a href="list.jsp?pageIndex=<%=pages.getPageIndex()-1%>">上一页</a>
		<%
			}
		%>
		<%
			int totalPage = pages.getTotalPage();
			for (int i = 1; i <= totalPage; i++){
				if (i == pages.getPageIndex()){
		%>
				<%=i %>
		<%
				} else {
		%>
				<a href="list.jsp?pageIndex=<%=i%>">[<%=i %>]</a>
		<%
				}
 			}
		%>
		<%
			if (pages.getPageIndex() < totalPage){
		%>
			<a href="list.jsp?pageIndex=<%=pages.getPageIndex()+1%>">下一页</a>
		<%
			}
		%>
		</td>
	</tr>
	
</table>
</body>
</html>