<%-- <%@page import="java.util.List"%> --%>
<%-- <%@page import="org.hamcrest.core.IsSame"%> --%>
<%-- <%@page import="com.min.inschool.dtos.cominfo_Dto"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공채일정 목록입니다.</title>



<style type="text/css">
#title1 {
	text-decoration: none;
}

</style>


</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>회사명</th>
			<th>공고명</th>
			<th>등록일</th>
			<th>마감일</th>
		</tr>
		<c:choose>
			<c:when test="${empty lists}">
				<tr>
					<td colspan="5">---작성된 글이 없습니다.---</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${lists}" var="dto">
					<tr>
						<td>${dto.co_seq}</td>
						<td>${dto.co_name}</td>
						<td><a href="#" id="title1" onclick="displayshow(this())">${dto.co_title}</a></td>
						<td>${dto.co_podate}</td>
						<td>${dto.co_exdate}</td>
					</tr>
					<tr id="display">
						<td colspan="5">지역 : ${dto.co_location}<br> 모집직종 :	${dto.co_jobtype}<br> 학력 : ${dto.co_exlevel}<br> 직종 :
							${dto.co_relevel}<br> 급여조건 : ${dto.co_salary}<br> 
							<a href="${dto.co_url}">[상세정보]</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</table>

	<table class="page">
		<tr>


			<c:choose>
				<c:when test="${'0' eq counts }">
					<td><c:forEach var="i" begin="0" end="${counts}" step="1">

							<a class="pageNum"
								href="comjob.do?s_num=${i<1?'1':(i*10)+1}&e_num=${i<1?'10':(i+1)*'10'}">
								${i+'1'}</a>

						</c:forEach></td>
				</c:when>


				<c:otherwise>
					<td><c:forEach var="i" begin="0" end="${counts-1}" step="1">

							<a class="pageNum"
								href="comjob.do?s_num=${i<1?'1':(i*10)+1}&e_num=${i<1?'10':(i+1)*'10'}">
								${i+'1'}</a>

						</c:forEach></td>


				</c:otherwise>
			</c:choose>

		</tr>
	</table>



</body>
</html>