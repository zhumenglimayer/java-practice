<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	/* String path = request.getContextPath(); */
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH }/static/scripts/jquery-3.2.1.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" id="page_info_area"></div>
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			to_page(1);
		});
		
		function to_page(pn){
			$.ajax({
				url : "${APP_PATH }/emps",
				data : "pn="+pn,
				type : "GET",
				success : function(result) {
					buildEmpsTable(result);
					buildPageInfo(result);
					buildPageNav(result);
				}
			});
		}

		function buildEmpsTable(result) {
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender=="M"?"男":"女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>").append(item.department.deptName);
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
				.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
				.append("編輯");
				var deleteBtn =$("<button></button>").addClass("btn btn-danger btn-sm")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
				.append("刪除");
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(deleteBtn);
				$("<tr></tr>").append(empIdTd).append(empNameTd)
				.append(genderTd).append(emailTd).append(deptNameTd)
				.append(btnTd).appendTo("#emps_table tbody");
			});
		}
		function buildPageInfo(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append("当前" +result.extend.pageInfo.pageNum+ "页，总共" +result.extend.pageInfo.pages+ "页，总共" +result.extend.pageInfo.total+ "条记录")
		}
		function buildPageNav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append($("<span></span>").append("&laquo;")).attr("href","#"));
			if(!result.extend.pageInfo.hasPreviousPage){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				firstPageLi.click(function(){
					to_page(1);
				});
				
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum-1);
				});
			}
			
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append($("<span></span>").append("&raquo;")).attr("href","#"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			
			
			if(!result.extend.pageInfo.hasNextPage){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum+1);
				});
				
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numPageLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
				if(result.extend.pageInfo.pageNum==item){
					numPageLi.addClass("active");
				}
				numPageLi.click(function(){
					to_page(item);
				});
				ul.append(numPageLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			$("<nav></nav>").append(ul).appendTo("#page_nav_area");
		}
	</script>
</body>
</html>