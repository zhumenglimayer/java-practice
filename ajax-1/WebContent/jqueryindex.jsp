<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			var url = this.href;
			$("#content").load(url);
			return false;
		})
	})
</script>
</head>
<body>
	<a href="aJax.txt" id="test">Hello Ajax</a>
	<div id="content"></div>
</body>
</html>