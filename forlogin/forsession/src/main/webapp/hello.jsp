<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	SessionID: <%= session.getId() %>
	<br/>
	IsNew: <%= session.isNew() %>
	<br/>
	MaxInactiveInterval: <%= session.getMaxInactiveInterval() %>
	<br/>
	CreateTime: <%= session.getCreationTime() %>
	<br/>
	LastAccessTime: <%= session.getLastAccessedTime() %>
	<br/>
	Hello: <%= request.getParameter("username") %>
	<br/>
	<%
		session.setAttribute("username", request.getParameter("username"));
	%>
	<a href="<%= response.encodeUrl("login.jsp") %>">重新登录</a>
	<a href="<%= response.encodeUrl("logout.jsp") %>">注销</a>
</body>
</html>