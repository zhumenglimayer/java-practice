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
	<%
		Object username = session.getAttribute("username");
	if(username == null){
		username = "";
	}
	%>
	<form action="<%= response.encodeUrl("hello.jsp") %>" method="post">
		username: <input type="text" name="username" value="<%= username%>"/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>