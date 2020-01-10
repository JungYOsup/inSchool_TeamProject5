<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<!---------------------------------- JQuey ------------------------------>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>


<!-------------------------------- 부트스트랩 -------------------------------------------------------->

<script
	src="resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"></script>
	

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!--------------------------------MultiDropDown메뉴 , 메뉴 src  -------------------------------------->

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />

<script
	src="${pageContext.request.contextPath}/resources/MultiDropdownMenu/js/modernizr.custom.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/MultiDropdownMenu/css/style.css"></script>

<script
	src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/jquery.min.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/dropdownmenu.min.js"></script>

<script>
		
		dropdownmenu.init();
		
</script>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<style type="text/css">
.
.sp-content {
	position: relative;
}

.col-lg-2 img {
	height: 175px;
	width: 175px;
}

#custom-login-btn img {
	height: 50px;
	width: 175px;
}

.title{

	background-color: #D8D8D8;
	
	font-weight: bold;
}
</style>

<script type="text/javascript">

	function popupOpen() {

		var popUrl = "chat.do"; //팝업창에 출력될 페이지 URL

		var popOption = "width=370, height=500, resizable=no, scrollbars=no, status=no;"; //팝업창 옵션(optoin)

		window.open(popUrl, "", popOption);

	}
	
</script>


<title>Justified Nav Template for Bootstrap</title>

</head>
<body>

	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>



		<!-- 광고가 들어가는 곳 -->

		<div class="container">


			<jsp:include page="carousel.jsp"></jsp:include>


		</div>

		<div>
			<hr>
		</div>

		<!-- 최신화 데이터를 보여주는 곳.-->
		<div class="row">
			<div class="col-lg-5">
				<table id="table01" class="table table-bordered">
					<tr>
						<td class="title">이력서게시판</td>
					</tr>

					<c:choose>
						<c:when test="${empty listResume}">

							<tr>
								<td>---------------작성된 글이 없습니다----------------</td>
							</tr>

						</c:when>
						<c:otherwise>

							<c:forEach items="${listResume}" var="dto1">
								<tr>
									<td><a href="detailboard.do?a_seq=${dto1.a_seq}">${dto1.a_title}</a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</table>
			</div>
			<div class="col-lg-5">
				<table id="table02" class="table table-bordered">
					<tr>
						<td class="title">면접게시판</td>
					</tr>

					<c:choose>
						<c:when test="${empty listInter}">

							<tr>
								<td>---------------작성된 글이 없습니다----------------</td>
							</tr>

						</c:when>
						<c:otherwise>

							<c:forEach items="${listInter}" var="dto2">

								<tr>
									<td><a href="detailboard.do?a_seq=${dto2.a_seq}">${dto2.a_title}</a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</table>
			</div>
			<div class="col-lg-2">

				<jsp:include page="Login.jsp"></jsp:include>
				
				<img onclick="popupOpen()" src="${ pageContext.request.contextPath }/resources/img/Messages.png" >
			</div>
		</div>

		<div class="row">
			<div class="col-lg-5">
				<table id="table03" class="table table-bordered">

					<tr>
						<td class="title">자유게시판</td>
					</tr>
					<c:choose>

						<c:when test="${empty listFree}">

							<tr>
								<td>---------------작성된 글이 없습니다----------------</td>
							</tr>

						</c:when>
						<c:otherwise>


							<c:forEach items="${listFree}" var="dto3">

								<tr>
									<td><a href="detailboard.do?a_seq=${dto3.a_seq}">${dto3.a_title}</a></td>
								</tr>
							</c:forEach>

						</c:otherwise>
					</c:choose>

				</table>
			</div>
			<div class="col-lg-5">
				<table id="table04" class="table table-bordered">

					<tr>
						<td class="title">질문게시판</td>
					</tr>


					<c:choose>

						<c:when test="${empty listQA}">

							<tr>
								<td>---------------작성된 글이 없습니다----------------</td>
							</tr>

						</c:when>
						<c:otherwise>

							<c:forEach items="${listQA}" var="dto4">

								<tr>
									<td><a href="detailboard.do?a_seq=${dto4.a_seq}">${dto4.a_title}</a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</table>
			</div>

			<div class="col-lg-2">
				
			</div>
		</div>



		<!-- Site footer -->
		<footer class="footer"> </footer>



	</div>
	<!-- /
 -->





</body>
</html>