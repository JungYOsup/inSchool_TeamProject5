
<%@page import="com.min.inschool.dtos.Join_T_Dtos"%>
<%@page import="com.min.inschool.dtos.Answer_T_Dtos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
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


<!-- Util사용위해 -->
<jsp:useBean id="util" class="com.min.inschool.dbinfo.Util" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<script type="text/javascript">


function insertForm(a_boardname) {
	
	
	location.href="write.do?a_boardname="+a_boardname;
	
	
	
}

function aa(grade) {
	
	if (grade=="일반회원"||grade=='') {
		alert("사용할수있는 권한이 없습니다.");
	}else{
		
	location.href="Boardname_boardlist.do?a_boardname=CV"
			
	} 
}



</script>
<style type="text/css">



</style>


</head>
<body>

	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		<div class="row">
	
			<!--게시판 선택리스트공간 -->
			<div class="col-xs-2">
			
			
			<!--리스트가 생길때마다 추가시켜주기만 추가시켜주기만 하면됨 -->
			<c:choose>
			<c:when test="${a_boardname eq 'CV' || a_boardname eq 'UV' }">
			
			<table>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=UV">유저동영상</a></td></tr>
				<tr><td><a onclick="aa('${user.j_grade}')">기업동영상</a></td></tr>
			
			</table>
			</c:when>
			
			
			
			</c:choose>
			
			<c:choose>
			<c:when test="${a_boardname eq 'IN'}">
			
			<table>
				<tr><td><a href="#">사이트 소개</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=IN">공지사항</a></td></tr>
			
			</table>
			</c:when>
			
			
			
			</c:choose>
			
			<c:choose>
			<c:when test="${a_boardname eq 'HOT'|| a_boardname eq 'AF' }">
			
			<table>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=HOT">면접준비 이슈사항</a></td></tr>
				<tr><td><a href="Calendarform.do?a_boardname=CD">공채일정달력</a></td></tr>
				<tr><td><a href="comjob.do?a_boardname=CI">기업채용 기간정보</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=AF">기업면접 후기</a></td></tr>
			</table>
			</c:when>
			
			
			
			</c:choose>
			
			<c:choose>
			<c:when test="${a_boardname eq 'PE_INFO'|| a_boardname eq 'MAJOR_INFO' || a_boardname eq 'MID_INFO'|| a_boardname eq 'SMALL_INFO'  }">
			
			<table>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=PE_INFO">공기업 면접정보</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=MAJOR_INFO">대기업 면접정보</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=MID_INFO">중견기업 면접정보</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=SMALL_INFO">중소기업 면접정보</a></td></tr>
			</table>
			</c:when>
			
			
			
			</c:choose>
			
			
			<c:choose>
			<c:when test="${a_boardname eq 'Book_LIST'|| a_boardname eq 'Book_Annotation' }">
			
			<table>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=Book_LIST">자소서항목</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=Book_Annotation">자소서첨삭</a></td></tr>
			</table>
			</c:when>
			
			
			
			</c:choose>
			
				<c:choose>
			<c:when test="${a_boardname eq 'Pass_spec'|| a_boardname eq 'Pass_Book' }">
			
			<table>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=Pass_spec">합격스펙</a></td></tr>
				<tr><td><a href="Boardname_boardlist.do?a_boardname=Pass_Book">합격자소서</a></td></tr>
			</table>
			</c:when>
			
			
			
			</c:choose>
			
			
			</div>


			<!--게시판 출력 공간-->
			<div class="col-xs-10">


				<table id="myTable" class="table table-striped" >
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회</th>
							<th>좋아요</th>
							<!-- <th>ref</th>
							화면에서 사실상 보여지면 안됨 
							<th>step</th>
							화면에서 사실상 보여지면 안됨 
							<th>depth</th>
							화면에서 사실상 보여지면 안됨  -->
						</tr>
					</thead>
					<c:choose>


						<c:when test="${empty lists}">
							<%-- ${empty lists} = lists객체가 비어있다면  --%>
							<tr>
								<td colspan="10">-------작성된 글이 없습니다.-------</td>
							</tr>
						</c:when>
						<c:otherwise>

							<c:forEach items="${lists}" var="dto">
								<!--lists의 길이만큼 반복  -->

								<tr>
									<td>${dto.a_seq}</td>


									<td><jsp:setProperty property="arrowNbsp" name="util"
											value="${dto.a_depth}" /> <jsp:getProperty
											property="arrowNbsp" name="util" /> <a
										href="detailboard.do?a_seq=${dto.a_seq}">${dto.a_option}${dto.a_title}[${dto.a_ansnum}]</a>

									</td>
									<td>${dto.a_name}</td>
									<td>${dto.a_regdate}</td>
									<td>${dto.a_recount}</td>
									<!--조회는 쿼리문을 추가해야함-->
									<td>${dto.funtion_T_Dtos.f_like}</td>
									<!--***좋아요는 쿼리문에서 추가해야함(추가함)  -->
									<%-- <td>${dto.a_ref}</td>
									<!--화면에서 나중에 보여지면 안됨  -->
									<td>${dto.a_step}</td>
									<td>${dto.a_depth}</td> --%>

								</tr>
							</c:forEach>





						</c:otherwise>
					</c:choose>
					<tr>
				</table>

				<table class="button">
					<tr>
						<td><input type="button" value="글쓰기" onclick="insertForm('${a_boardname}')">
						</td>
					</tr>
				</table>


				<table class="page">
					<tr>


						<c:choose>
							<c:when test="${'0' eq counts }">
								<td><c:forEach var="i" begin="0" end="${counts}" step="1">

										<a class="pageNum"
											href="Boardname_boardlist.do?s_num=${i<1?'1':(i*10)+1}&e_num=${i<1?'10':(i+1)*'10'}&a_boardname=${a_boardname}">
											${i+'1'}</a>

									</c:forEach></td>
							</c:when>


							<c:otherwise>
								<td><c:forEach var="i" begin="0" end="${counts-1}" step="1">

										<a class="pageNum"
											href="Boardname_boardlist.do?s_num=${i<1?'1':(i*10)+1}&e_num=${i<1?'10':(i+1)*'10'}&a_boardname=${a_boardname}">
											${i+'1'}</a>

									</c:forEach></td>


							</c:otherwise>
						</c:choose>

					</tr>
				</table>


				<form action="searchword.do" method="post">

					<table class="search">
						<tr>
							<td>
								<!--내가 이 페이지를 눌렀을때 UV가 전달되게끔 해주면 된다.  --> <input type="hidden"
								name="a_boardname" value="${a_boardname}">
								
								<select name="searchoption">
									<option value="제목+내용">제목+내용</option>
									<option value="제목만">제목만</option>
									<option value="작성자">작성자</option>
							</select>
							</td>

							<td><input type="search" name="searchword"></td>
							<td><button>검색</button></td>
						</tr>

					</table>

				</form>


			</div>

		</div>


		<script
			src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/jquery.min.js"></script>
		<script
			src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/dropdownmenu.min.js"></script>

		<script>
		
		dropdownmenu.init();
		
		</script>

	</div>
	<!-- /container -->





</body>
</html>