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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

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
	function insertForm(a_boardname) {

		alert(a_boardname);

		location.href = "write.do?a_boardname=" + a_boardname;

	}
</script>


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



				<jsp:include page="Calendar.jsp"></jsp:include>


			</div>


		</div>
	</div>
	<!-- /container -->
</body>
</html>