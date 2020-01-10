<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 구분창 입니다.(유저 기업)</title>
<style type="text/css">
img {
	margin-left: 170px;
}

button {
	width: 300px;
}

table {
	margin-left: 15px;
	margin-top: 10px;
}

</style>

<script type="text/javascript">
	
	function UserClick() {
		
		document.getElementById("Uregist").setAttribute("style", "display: block");
		document.getElementById("Cregist").setAttribute("style", "display: none");
		
		document.getElementById("Cbutton").setAttribute("class", "btn btn-default btn-lg");
		document.getElementById("Ubutton").setAttribute("class", "btn btn-primary btn-lg");
		
	}
	
	function CUserClick() {
		
		document.getElementById("Cregist").setAttribute("style", "display: block");
		document.getElementById("Uregist").setAttribute("style", "display: none");
		
		document.getElementById("Ubutton").setAttribute("class", "btn btn-default btn-lg");
		document.getElementById("Cbutton").setAttribute("class", "btn btn-primary btn-lg");
	}
	function clickimage() {
		location.href="main.do";
	}

</script>


</head>
<body>

	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="row">
				<div class="col-sm-12">
					<img alt="회원가입광고" src="images/bener2.JPG" onclick="clickimage()">
					<div class="row">
						<div class="col-xs-8 col-sm-6">
							<button id="Ubutton" class="btn btn-primary btn-lg " style="margin-left: 16px;" onclick="UserClick()">일반회원</button>
						</div>
						<div class="col-xs-4 col-sm-6">
							<button id="Cbutton" class="btn btn-default btn-lg " style="margin-left: 16px;" onclick="CUserClick()">기업회원</button>
								
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-4"></div>
	</div>
	
	<div class="row" id="Uregist"> 
		<div class="col-xs-6 col-md-4"></div>
		<div class="col-xs-6 col-md-4"><jsp:include page="Uregist.jsp"></jsp:include></div>
		<div class="col-xs-6 col-md-4"></div>
	</div>
	
	<div class="row" id="Cregist" style="display: none;"> 
		<div class="col-xs-6 col-md-4"></div>
		<div class="col-xs-6 col-md-4"><jsp:include page="Cregist.jsp"></jsp:include></div>
		<div class="col-xs-6 col-md-4"></div>
	</div>









	<!-- <form action="regist.do" method="post">
		<table>
			<tr>
				<td><input type="submit" value="일반회원" name="id"
					class="btn btn-default"></td>
				<td><input type="submit" value="기업회원" name="id"
					class="btn btn-default"></td>
			</tr>
		</table>
	</form> -->




</body>
</html>