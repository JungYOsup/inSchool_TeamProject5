<%@page import="com.min.inschool.daos.YsDao"%>
<%@page import="com.min.inschool.dtos.Join_T_Dtos"%>
<%@page import="com.min.inschool.dtos.Answer_T_Dtos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@page import="java.net.URLEncoder"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<title>Insert title here</title>

<style type="text/css">
@charset "UTF-8";

@import url(https://fonts.googleapis.com/css?family=Lato:400,700);

* {
	margin: 0;
	padding: 0;
	font-family: tahoma;
}

#table1 {
	border: none;
}

body {
	background-color: #f8f8f8;
	padding: 50px;
	font-family: 'Lato', sans-serif;
}

h1 {
	font-family: tahoma;
	color: #999;
	font-size: 24px;
}

P {
	font-family: 돋움;
	font-size: 12px;
	letter-spacing: -1px;
	margin-bottom: 40px;
}

#table2 {
	display: inline-block;
}

one {
	width: 200px;
	height: 100px;
}

.head {
	font-size: 11pt;
	background-color: #EAEAEA;
	width: 130px;
	height: 50px;
	border: 1px;
	text-align: center;
	color: #A6A6A6;
	border-bottom-style: solid;
}

#z2 {
	height: 23px;
}

#z1 {
	height: 40px;
	font-size: 10pt;
}

#table1 {
	margin-left: auto;
	margin-left: auto;
}
</style>

<script type="text/javascript">
		
		function updateform(seq) {
			alert(seq);
			location.href ="updateform.do?seq="+seq;
		}

</script>

</head>
<body topmargin="0" leftmargin="0">
	<table width="76%" id="table1">
		<tr>
			<td colspan="2">
				<h1>My Profile</h1>
				<table border="1" width="485" height="100">
					<tr>
						<td>
							<table id="one">
								<tr>
									<td colspan="3"><input type="text" value="아이디" id="z1"
										style="text-align: center;"></td>
								</tr>
								<tr>
									<td><input type="text" value="${adto.j_name}"
										style="background-color: transparent; border: 0 solid black; text-align: center;"></td>
								</tr>
							</table> <span><input type="button" value="개인정보 수정하기"
								onclick="updateform(${adto.j_seq})"
								style="background-color: #f8f8f8; color: #999; text-align: center; position: relative; margin-left: 20px;"></span>
						</td>
						<td>
							<table id="two">
								<tr>
									<td class="head">비밀번호<span style="color: red">*</span></td>
									<td><input type="text" value="${adto.j_pass}" id="z2">
									</td>
								</tr>
								<tr>
									<td class="head">주소<span style="color: red">*</span></td>
									<td><input type="text" value="${adto.j_addr }"> <input
										type="text" value="${adto.j_deaddr}"></td>
								</tr>
								<tr>
									<td class="head">생년월일<span style="color: red">*</span></td>
									<td><input type="text" value="${adto.j_birth}" id="z2">
									</td>
								</tr>
								<tr>
									<td class="head">우편번호<span style="color: red">*</span></td>
									<td><input type="text" value="${adto.j_post}" id="z2"></td>
								</tr>
								<tr>
									<td class="head">이메일<span style="color: red">*</span></td>
									<td><input type="text" value="${adto.j_email}" id="z2"></td>
								</tr>
								<tr>
									<td class="head">직종<span style="color: red">*</span></td>
									<td><input type="text" value="${adto.j_job}" id="z2"></td>
								</tr>

								<c:choose>
									<c:when test="${adto.j_comnum eq '0'}">



										<tr>
											<td class="head">유저번호<span style="color: red">*</span></td>
											<td><input type="text" value="${adto.j_unum}" id="z2"></td>
										</tr>

									</c:when>

									<c:otherwise>

										<tr>
											<td class="head">기업번호<span style="color: red">*</span></td>
											<td><input type="text" value="${adto.j_comnum}" id="z2"></td>
										</tr>


									</c:otherwise>

								</c:choose>


							</table>
						</td>
					</tr>
				</table>
			</td>
			<td>
				<h1>나를 추천한 기업</h1>
					<c:choose>
							<c:when test="${empty Clists}">

							<td>---------즐겨찾기를 하지 않았습니다.-----------</td>

							</c:when>

							<c:otherwise>
								
								<c:forEach items="${Clists}" var="dto" >
								
								
								<ul>
								<!--여기서 눌렀을때 상세페이지로 이동해야한다. 그런데 get방식으로 넘어가므로 한글이 깨져서 넘어가는데 이것을 해결해야한다.-->
									<li><a href="recommendcomjob.do?co_name=${dto.j_name}">회사명:${dto.j_name}</a></li>
								
								
								</ul>
							
								</c:forEach>
								


							</c:otherwise>
						</c:choose>
			</td>
		</tr>

		<tr>
			<td>
				<h1>즐겨찾기한 게시판</h1>
				
						<c:choose>
							<c:when test="${empty Slists}">

							<td>---------즐겨찾기를 하지 않았습니다.-----------</td>

							</c:when>

							<c:otherwise>
								
								<c:forEach items="${Slists}" var="dto" >
								
								
								<ul>
								<!--여기서 눌렀을때 상세페이지로 이동해야한다. -->
									<li><a href="detailboard.do?a_seq=${dto.a_seq}"> 게시글:${dto.a_seq} 글제목:${dto.a_title}detailboard.do</a></li>
								
								
								</ul>
							
								</c:forEach>
								


							</c:otherwise>
						</c:choose>
					
			</td>

		</tr>
	</table>
</body>
</html>