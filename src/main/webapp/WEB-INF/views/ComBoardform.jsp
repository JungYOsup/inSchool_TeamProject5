<%@page import="com.min.inschool.dtos.Join_T_Dtos"%>
<%@page import="com.min.inschool.dtos.Answer_T_Dtos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>

<!---------------------------------- JQuey ------------------------------>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script
	src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/jquery.min.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/dropdownmenu.min.js"></script>

<script>
	dropdownmenu.init();
</script>


<!-- Util사용위해 -->
<jsp:useBean id="util" class="com.min.inschool.dbinfo.Util" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script type="text/javascript">
	window.onload = function() {

		var title = document.getElementsByClassName("display");

		for (var i = 0; i < title.length; i++) {
			title[i].style.display = "none";

		}
	}

	function doDisplay(title) {

		if (title.parentNode.parentNode.nextSibling.nextSibling.style.display == "none") {

			title.parentNode.parentNode.nextSibling.nextSibling.style.display = "";
			// block으로 하면 colspan이 적용이 안됨, 따라서 table-row로 하던
			//""공백을 주던 해야한다. //이유는 잘 모르겠으나 이제부터 none을 풀어줄때는 block말고 공백을 쓰도록 하자
		} else {
			title.parentNode.parentNode.nextSibling.nextSibling.style.display = "none";

		}

	}

	/*jquery로 할시  */
	/* window.onload = function() {

		$(".display").hide();

		
	}

	function doDisplay(title) {


			$(title).parents("tr").next().toggle();
		

	} */

	function insertForm(a_boardname) {

		alert(a_boardname);

		location.href = "write.do?a_boardname=" + a_boardname;

	}
</script>
<style type="text/css">
#title1 {
	text-decoration: none;
}
</style>


<title>Justified Nav Template for Bootstrap</title>

</head>
<body>

	<div class="container">


		<jsp:include page="header.jsp"></jsp:include>

		<div class="row">

			<!--게시판 선택리스트공간 -->
			<div class="col-xs-2">


				<!--리스트가 생길때마다 추가시켜주기만 추가시켜주기만 하면됨 -->
				<c:choose>

					<c:when test="${a_boardname eq 'CD' || a_boardname eq 'CI'}">

						<table>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=HOT">면접준비 이슈사항</a></td>
							</tr>
							<tr>
								<td><a href="Calendarform.do?a_boardname=CD">공채일정달력</a></td>
							</tr>
							<tr>
								<td><a href="comjob.do?a_boardname=CI">기업채용 기간정보</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=AF">기업면접 후기</a></td>
							</tr>

						</table>
					</c:when>




				</c:choose>


			</div>


			<!--게시판 출력 공간-->
			<div class="col-xs-10">
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
									<td><a href="#" id="title1" onclick="doDisplay(this);">${dto.co_title}</a></td>
									<!--this는 <a>태그를 의미해버림  -->
									<td>${dto.co_podate}</td>
									<td>${dto.co_exdate}</td>
								</tr>
								<tr class="display">
									<td colspan="5">지역: ${dto.co_location}<br> 모집직종 :
										${dto.co_jobtype}<br> 학력 : ${dto.co_exlevel}<br> 직종
										: ${dto.co_relevel}<br> 급여조건 : ${dto.co_salary}<br>
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
											href="comjob.do?s_num=${i<1?'1':(i*10)+1}&e_num=${i<1?'10':(i+1)*'10'}&a_boardname=CI">
											${i+'1'}</a>

									</c:forEach></td>
							</c:when>


							<c:otherwise>
								<td><c:forEach var="i" begin="0" end="${counts-1}" step="1">

										<a class="pageNum"
											href="comjob.do?s_num=${i<1?'1':(i*10)+1}&e_num=${i<1?'10':(i+1)*'10'}&a_boardname=CI">
											${i+'1'}</a>

									</c:forEach></td>


							</c:otherwise>
						</c:choose>

					</tr>
				</table>

			</div>


		</div>
	</div>
	<!-- /container -->
</body>
</html>