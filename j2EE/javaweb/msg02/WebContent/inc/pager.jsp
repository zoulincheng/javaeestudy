<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>

<%
	int items = Integer.parseInt(request.getParameter("items"));
	String params = request.getParameter("params");
	if (params == null)
		params = "";
	String[] ps = params.split(",");
%>

<pg:pager maxPageItems="15" items="<%=items %>" export="curPage=number">
<%
	for (String p:ps){
%>
	<pg:param name="<%=p %>"/>
<%		
	}
%>
	<pg:last>
 一共有：<%=items %>条记录，共<%=pageNumber %>页，当前是第<%=curPage %>页，每页显示条记录
 	</pg:last> 
	<pg:first>
		<a href="<%=pageUrl%>">首页</a>
	</pg:first>
	
	<pg:prev>
		<a href="<%=pageUrl%>">上一页</a>
	</pg:prev>
	
	<pg:pages>
	<%
		if(curPage == pageNumber){
	%>
		[<%=pageNumber %>]
	<%
		} else{
	%>
		<a href="<%=pageUrl%>"><%=pageNumber %></a>
	<%
		}
	%>
	</pg:pages>
	
	<pg:next>
		<a href="<%=pageUrl%>">下一页</a>
	</pg:next>
	
	<pg:last>
		<a href="<%=pageUrl%>">尾页</a>
	</pg:last>
</pg:pager>

