<%@page import="com.min.inschool.dtos.Answer_T_Dtos"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">


	function insertForm() {
		
		location.href="daum.do";
		
	}
	

</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저 동영상 게시판</title>
</head>



<body>

<h1>유저 동영상 게시판</h1>


<form action="muldel.do" method="post">
<table class="table table-hover">

	
	
	<!--나중에 FRAMWORK(MIT공대에서 만든)이용해서 오름차순 내림차순 할수있게 해주자  -->
	<tr>
		<th>말머리선택(번호)</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회</th>
		<th>좋아요</th>
		<th>ref</th> <!--화면에서 사실상 보여지면 안됨  -->
		<th>step</th> <!--화면에서 사실상 보여지면 안됨  -->
		<th>depth</th> <!--화면에서 사실상 보여지면 안됨  -->
		
	</tr>
	<c:choose>		
	<c:when test="${empty lists}"> 	<%-- ${empty lists} = lists객체가 비어있다면  --%>
			<tr><td colspan="10">-------작성된 글이 없습니다.-------</td></tr>
	</c:when>
	<c:otherwise>	
		<c:forEach items="${lists}" var="dto"> <!--lists의 길이만큼 반복  -->
		
			<tr>
				<td>${dto.a_seq}</td>
				<td><a href="detailboard.do?a_seq=${dto.a_seq}">${dto.a_option}${dto.a_title}</a></td>
				<td>${dto.a_name}</td>
				<td>${dto.a_regdate}</td>
				<td>${dto.a_recount}</td><!--조회는 쿼리문을 추가해야함-->
				<td>${dto.funtion_T_Dtos.f_like}</td><!--***좋아요는 쿼리문에서 추가해야함(추가함)  -->
				<td>${dto.a_ref}</td><!--화면에서 나중에 보여지면 안됨  -->
				<td>${dto.a_step}</td>
				<td>${dto.a_depth}</td>
			</tr>
		</c:forEach>
			
		
	
	
		
	</c:otherwise>			
	</c:choose>
			
	<tr>
	<td colspan="10">
		<input type="button" value="글추가" onclick="insertForm()">
	</td>
	</tr>
</table>
</form>

</body>

</html>