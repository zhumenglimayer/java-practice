<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		var isHasCart = "${sessionScope.sc==null}";
		if(isHasCart=="true"){
			$("#cartView").hide();
		}else{
			$("#cartView").show();
			$("#bookName").text("${sessionScope.sc.bookName}");
			$("#totalNumber").text("${sessionScope.sc.totalNumber}");
			$("#totalMoney").text("${sessionScope.sc.totalMoney}"); 
		}
		$("a").click(function(){
			$("#cartView").show();
			var url = this.href;
			var args = {"time":new Date()};
			$.getJSON(url,args,function(data){
				$("#bookName").text(data.bookName);
				$("#totalNumber").text(data.totalNumber);
				$("#totalMoney").text(data.totalMoney);
			});
			return false;
		});
	})
</script>
</head>
<body>

	<div id="cartView">
	您已经将 &nbsp;<span id="bookName"></span>&nbsp; 加入到购物车中。
	购物车中的书有 &nbsp;<span id="totalNumber"></span>&nbsp; 本。
	总价格 &nbsp;<span id="totalMoney"></span>&nbsp; 人民币。
	</div>
	<br/>
	Java&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=java&price=100">加入购物车</a>
	<br/>
	Python&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=python&price=200">加入购物车</a>
	<br/>
	Ruby&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/addToCart?id=ruby&price=300">加入购物车</a>
	<br/>
</body>
</html>