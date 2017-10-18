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
	<!-- 员工新增模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="emp_add_input" class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="empName"
									id="emp_add_input" placeholder="Email"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="email_add_input" class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="email"
									id="email_add_input" placeholder="Email@163.com"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">gender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_add_input" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_add_input" value="F"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">deptName</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId" id="depts_add_input">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_add_save">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 员工修改模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" >员工修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="emp_add_input" class="col-sm-2 control-label">empName</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="empName_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="email_add_input" class="col-sm-2 control-label">email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" name="email"
									id="email_update_input" placeholder="Email@163.com"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">gender</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_update_input" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_update_input" value="F"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">deptName</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId" id="depts_update_input">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="emp_update_save">更新</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal">新增</button>
				<button class="btn btn-danger" id="emp_delete_all">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkbox_all"/></th>
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
		var totalRec;
		var currentPage;
		$(function() {
			to_page(1);
		});

		function to_page(pn) {
			$.ajax({
				url : "${APP_PATH }/emps",
				data : "pn=" + pn,
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
			$.each(emps, function(index, item) {
				var checkBoxTd = $("<td></td>").append($("<input type='checkbox' class='checkboxs'/>"));
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(
						item.gender == "M" ? "男" : "女");
				var emailTd = $("<td></td>").append(item.email);
				var deptNameTd = $("<td></td>")
						.append(item.department.deptName);
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm edit_btn").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append("編輯");
				editBtn.attr("edit-id",item.empId);
				var deleteBtn = $("<button></button>").addClass(
						"btn btn-danger btn-sm delete_btn").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"刪除");
				deleteBtn.attr("del-id",item.empId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						deleteBtn);
				$("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).append(
						genderTd).append(emailTd).append(deptNameTd).append(
						btnTd).appendTo("#emps_table tbody");
			});
		}
		function buildPageInfo(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前" + result.extend.pageInfo.pageNum + "页，总共"
							+ result.extend.pageInfo.pages + "页，总共"
							+ result.extend.pageInfo.total + "条记录")
			totalRec = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		function buildPageNav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append($("<span></span>").append("&laquo;"))
							.attr("href", "#"));
			if (!result.extend.pageInfo.hasPreviousPage) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				firstPageLi.click(function() {
					to_page(1);
				});

				prePageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append($("<span></span>").append("&raquo;"))
							.attr("href", "#"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));

			if (!result.extend.pageInfo.hasNextPage) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				nextPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				});

				lastPageLi.click(function() {
					to_page(result.extend.pageInfo.pages);
				});
			}
			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numPageLi = $("<li></li>").append(
						$("<a></a>").append(item).attr("href", "#"));
				if (result.extend.pageInfo.pageNum == item) {
					numPageLi.addClass("active");
				}
				numPageLi.click(function() {
					to_page(item);
				});
				ul.append(numPageLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			$("<nav></nav>").append(ul).appendTo("#page_nav_area");
		}
		
		function reset_form(ele){
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").text("");
		}

		$("#emp_add_modal").click(function() {
			reset_form("#empAddModal form");
			getDepts("#depts_add_input");
			$('#empAddModal').modal({
				backdrop : "static"
			});
		});

		function getDepts(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH }/depts",
				type : "GET",
				success : function(result) {
					$.each(result.extend.depts, function() {
						var optionEle = $("<option></option>").append(
								this.deptName).attr("value", this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});
		}

		$("#emp_add_input").change(function() {

			var empName = $("#emp_add_input").val();
			$.ajax({
				url : "${APP_PATH }/checkuser",
				type : "POST",
				data : "empName=" + empName,
				success : function(result) {
					if (result.code == 100) {
						showValidateMsg("#emp_add_input", "success", "用户名可用");
						$("#emp_add_save").attr("ajax-va","success");
					} else {
						showValidateMsg("#emp_add_input", "error", result.extend.va_msg);
						$("#emp_add_save").attr("ajax-va","error");
					}
				}
			});
		});

		function validateAddForm() {
			var empName = $("#emp_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{3,6}$)/;
			if (!regName.test(empName)) {
				showValidateMsg("#emp_add_input", "error",
						"用户名必须为6-16位英文或者3-6位中文");
				return false;
			} else {
				showValidateMsg("#emp_add_input", "success", "");
			}
			var email = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (!regEmail.test(email)) {
				showValidateMsg("#email_add_input", "error", "邮箱格式不正确");
				return false;
			} else {
				showValidateMsg("#email_add_input", "success", "");
			}
			return true;
		}

		function showValidateMsg(ele, status, msg) {
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");

			if ("success" == status) {
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			} else if ("error" == status) {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}

		$("#emp_add_save").click(function() {
			if ($("#emp_add_save").attr("ajax-va") == "error") {
				return false;
			}
			 if (!validateAddForm()) {
				return false;
			} 
			
			$.ajax({
				url : "${APP_PATH }/emp",
				type : "POST",
				data : $("#empAddModal form").serialize(),
				success : function(result) {
					if(result.code==100){
						$("#empAddModal").modal('hide');
						to_page(totalRec);
					}else{
						if(undefined!=result.extend.errorFileds.empName){
							showValidateMsg("#emp_add_input", "error", result.extend.errorFileds.empName);
						}
						if(undefined!=result.extend.errorFileds.email){
							showValidateMsg("#email_add_input", "error", result.extend.errorFileds.email);
						}
					}
					
				}
			});
		});
		
		$(document).on("click",".edit_btn",function(){
			getDepts("#empUpdateModal select");
			buildEmpUpdateModal($(this).attr("edit-id"));
			$("#emp_update_save").attr("edit-id",$(this).attr("edit-id"));
			$('#empUpdateModal').modal({
				backdrop : "static"
			});
		});
		
		$(document).on("click",".delete_btn",function(){
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			var empId = $(this).attr("del-id");
			if(confirm("是否删除【"+empName+"】的数据")){
				$.ajax({
					url:"${APP_PATH }/emp/"+empId,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						to_page(currentPage);
					}
				});
			}
		});
		
		function buildEmpUpdateModal(id){
			$.ajax({
				url:"${APP_PATH }/emp/"+id,
				type:"GET",
				success:function(result){
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.dId]);
				}
			});
		}
		
		$("#emp_update_save").click(function(){
			var email = $("#email_update_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if (!regEmail.test(email)) {
				showValidateMsg("#email_update_input", "error", "邮箱格式不正确");
				return false;
			} else {
				showValidateMsg("#email_update_input", "success", "");
			}
			
			$.ajax({
				url:"${APP_PATH }/emp/"+$("#emp_update_save").attr("edit-id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					$("#empUpdateModal").modal('hide');
					to_page(currentPage);
				}
			});
		});
		
		$("#checkbox_all").click(function(){
			$(".checkboxs").prop("checked",$("#checkbox_all").prop("checked"));
		});
		
		$(document).on("click",".checkboxs",function(){
			var flag = $(".checkboxs:checked").length==$(".checkboxs").length;
			$("#checkbox_all").prop("checked",flag);
		});
		
		$("#emp_delete_all").click(function(){
			var empNames = "";
			var del_ids = "";
			$.each($(".checkboxs:checked"),function(){
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				del_ids += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			empNames = empNames.substring(0,empNames.length-1);
			del_ids = del_ids.substring(0,del_ids.length-1);
			if(confirm("确认删除【"+empNames+"】吗？")){
				$.ajax({
					url:"${APP_PATH }/emp/"+del_ids,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						to_page(currentPage);
					}
				});
			}
		});
	</script>
</body>
</html>