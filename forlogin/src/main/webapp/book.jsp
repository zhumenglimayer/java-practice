<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Book Detail Page</h4>
	Book:
	<%= request.getParameter("book") %>
	<br />
	<a href="books.jsp">Return</a>

	<%
		
		String book = request.getParameter("book");
		Cookie [] cookies = request.getCookies();
		List<Cookie> bookcookies = new ArrayList<Cookie>();
		Cookie tempCookie = null;
		if(cookies != null && cookies.length > 0){
			for(Cookie c : cookies){
				String cookieName = c.getName();
				if(cookieName.startsWith("Mayer_Book_")){
					bookcookies.add(c);
					if(c.getValue().equals(book)){
						tempCookie = c;
					}
				}
			}
			
		}
		
		if(bookcookies.size() >= 5 && tempCookie == null){
			tempCookie = bookcookies.get(0);
		}
		if(tempCookie != null){
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
		Cookie cookie = new Cookie("Mayer_Book_" + book , book);
		response.addCookie(cookie);
		
	%>
</body>
</html>