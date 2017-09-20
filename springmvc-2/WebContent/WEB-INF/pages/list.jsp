<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("#deleteForm").attr("action",href).submit();
			return false;
		});
	})
</script>
</head>
<body>
	<form action="" method="post" id="deleteForm">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	<c:if test="${empty requestScope.Emps }">
		没有员工信息
	</c:if>
	<c:if test="${!empty requestScope.Emps }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${requestScope.Emps }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender==0 ? 'Female' : 'Male' }</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="emp/${emp.id }">Edit</a></td>
					<td><a class="delete" href="emp/${emp.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="emp">Add New Employee</a>
</body>
</html>