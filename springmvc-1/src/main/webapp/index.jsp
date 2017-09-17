<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="helloworld">Hello World!!!!</a>
	<br/>
	<br/>
	<a href="springmvc/testRequestMapping">Test RequestMapping</a>
	<br/>
	<br/>
	<a href="springmvc/testMethod">Test Method</a>
	<br/>
	<br/>
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="submit"/>
	</form>
	<br/>
	<br/>
	<a href="springmvc/testPathVariable/2/jerry">Test PathVariable</a>
	<br/>
	<br/>
	<a href="springmvc/testRest/1">TestRest GET</a>
	<br/>
	<br/>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="Test POST"/>
	</form>
	<br/>
	<br/>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="Test DELETE"/>
	</form>
	<br/>
	<br/>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="Test PUT"/>
	</form>
	<br/>
	<br/>
	<a href="springmvc/testRequestParam?username=root&age=11">TestRest Param</a>
	<br/>
	<br/>
	<a href="springmvc/testRequestHeader">TestRest RequestHeader</a>
	<br/>
	<br/>
	<a href="springmvc/testCookieValue">TestRest CookieValue</a>
	<br/>
	<br/>
	<form action="springmvc/testPOJO">
		username:<input type="text" name="username"/><br/>
		password:<input type="password" name="password"/><br/>
		gender:<input type="text" name="gender"/><br/>
		email:<input type="text" name="email"/><br/>
		age:<input type="text" name="age"/><br/>
		province:<input type="text" name="address.province"/><br/>
		city:<input type="text" name="address.city"/><br/>
		<input type="submit" value="submit"/>
	</form>
	<br/>
	<br/>
	<a href="springmvc/testServletAPI">Test ServletAPI</a>
	<br/>
	<br/>
	<a href="springmvc/testModelAndView">Test ModelAndView</a>
	<br/>
	<a href="springmvc/testMap">Test Map</a>
	<br/>
	<a href="springmvc/testSessionAttribute">Test SessionAttribute</a>
	<br/>
	<form action="springmvc/testModelAttribute">
		<input type="hidden" name="id" value="1"/>
		username:<input type="text" name="username" value="Tom"/><br/>
		gender:<input type="text" name="gender" value="1"/><br/>
		email:<input type="text" name="email" value="Tom@163.com"/><br/>
		age:<input type="text" name="age" value="12"/><br/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>