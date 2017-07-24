<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Books Page</h3>
	<a href="book.jsp?book=Java">Java</a>
	<a href="book.jsp?book=Oracle">Oracle</a>
	<a href="book.jsp?book=Ajax">Ajax</a>
	<a href="book.jsp?book=Javascript">Javascript</a>
	<a href="book.jsp?book=Spring">Spring</a>
	<a href="book.jsp?book=Python">Python</a>
	<a href="book.jsp?book=Ruby">Ruby</a>
	<a href="book.jsp?book=Vue">Vue</a>
	<a href="book.jsp?book=Android">Android</a>
	<br/>
	<br/>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie c : cookies){
				String cookieName = c.getName();
				if(cookieName.startsWith("Mayer_Book_")){
					out.print(c.getValue());
					out.print("<br/>");
					
				}
			}
	
		}
	%>
</body>
</html>