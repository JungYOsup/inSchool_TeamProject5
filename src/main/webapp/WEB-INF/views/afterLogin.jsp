<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

function logout() {
	
	location.href="Logout.do";
	
}




</script>

<style type="text/css">

.circle1{
	background-color: #E6E6E6;
	width: 30px;
	height: 30px;
	border-radius: 100px;
	
}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>

		<tr>
			<td><input type="text"
				placeholder="${user.j_name}님(${user.j_grade})환영합니다"></td><td><div class="circle1"><p style="color: blue; text-align: center; line-height: 30px;">${count}</p></div></td>
		</tr>

		<tr>
			<td>
				<button onclick="location.href='MyInform.do?seq=${user.j_seq}&a_unum=${user.j_unum}'">내정보</button><button onclick="logout()">로그아웃</button>
			</td>
			
				
			

		</tr>



	</table>

</body>
</html>