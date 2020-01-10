<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!--------------------------------MultiDropDown메뉴 , 메뉴 src  -------------------------------------->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/modernizr.custom.js"></script>
<link
	href="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/css/style.css"
	rel="stylesheet">

<script type="text/javascript">
	function aa(grade) {

		if (grade == "일반회원" || grade == '') {
			alert("사용할수있는 권한이 없습니다.");
		} else {

			location.href = "Boardname_boardlist.do?a_boardname=CV"

		}
	}
</script>

<style type="text/css">
.headerimage {
	width: 200px;
	height: 80px;
}

#search{

	margin-left: 150px;
}
</style>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Justified Nav Template for Bootstrap</title>

</head>
<body>

	<div>
		<div class="masthead">
		<table>
			
			<tr><td><h3 class="text-muted">
				<img onclick="location.href='main.do'" src="images/bener2.JPG"
					class="headerimage"></img>
			</h3></td><td><form action="search00.do" method="post">
				<table id="search">
					<tr>
						<td><select style="height: 30px;" name="select01" >
								<option value="searchAllinfo">전체검색</option>
								<option value="titleOnly">제목만</option>
								<option value="writer">작성자</option>
						</select></td>
						<td><input type="text" placeholder="검색어를 넣어주세요" name="word"
							style="width: 250px; height: 30px;" class="form-control" /></td>
						<td><input type="submit" value="검색" class="btn btn-default" style="height: 30px;"/></td>
					</tr>
				</table>
			</form></td></tr>
		
		
		</table>
					


			<div class="main">
				<nav class="menu" id="menu">
					<ul>

						<li><a href="#">소개</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>소개</h4>
										<ul>
											<li><a href="Showform.do?a_boardname=SH">사이트소개</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=IN">공지사항</a></li>

										</ul>
									</div>
									<div></div>

								</div>
							</div></li>
						<li><a href="#">동영상</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>동영상</h4>
										<ul>
											<li><a href="Boardname_boardlist.do?a_boardname=UV">유저동영상</a></li>
											<li><a onclick="aa('${user.j_grade}')">기업동영상</a></li>
										</ul>
									</div>
									
									<!--추가할 내용이 있으면 추가해주자   -->
									<!-- <div>
										<h4>Belajar2</h4>
										<ul>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
										</ul>
									</div> -->

								</div>
							</div></li>
						<li><a href="#">면접게시판</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>면접게시판</h4>
										<ul>
											<li><a href="Boardname_boardlist.do?a_boardname=HOT">면접준비 이슈사항</a></li>
											<li><a href="Calendarform.do?a_boardname=CD">공채일정달력</a></li>
											<li><a href="comjob.do?a_boardname=CI">기업채용 기간정보</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=AF">기업면접 후기</a></li>
										</ul>
									</div>
									<div>
										<h4>면접정보</h4>
										<ul>
											<li><a href="Boardname_boardlist.do?a_boardname=PE_INFO">공기업 면접정보</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=MAJOR_INFO">대기업 면접정보</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=MID_INFO">중견기업 면접정보</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=SMALL_INFO">중소기업 면접정보</a></li>
										</ul>
									</div>

								</div>
							</div></li>
						<li><a href="#">이력서게시판</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>이력서</h4>
										<ul>
											<li><a href="Boardname_boardlist.do?a_boardname=Book_LIST">자소서항목</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=Book_Annotation">자소서첨삭</a></li>
										</ul>
									</div>
									<div>
										<h4>합격정보</h4>
										<ul>
											<li><a href="Boardname_boardlist.do?a_boardname=Pass_spec">합격스펙</a></li>
											<li><a href="Boardname_boardlist.do?a_boardname=Pass_Book">합격자소서</a></li>
										</ul>
									</div>

								</div>
							</div></li>
						<li><a href="#">학습게시판</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>소개</h4>
										<ul>
											<li><a href=""></a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
										</ul>
									</div>
									<div>
										<h4>Belajar2</h4>
										<ul>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
										</ul>
									</div>

								</div>
							</div></li>
						<li><a href="#">자유게시판</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>이야기방</h4>
										<ul>
											<li><a href="">취준생이야기방</a></li>
											<li><a href="">대학생이야기방</a></li>
											<li><a href="">현직자이야기방</a></li>
											<li><a href="">퇴사자이야기방</a></li>
										</ul>
									</div>
									<div>
										<h4></h4>
										<ul>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
										</ul>
									</div>

								</div>
							</div></li>
						<li><a href="#">Q&A</a>
							<div class="sub-menu">
								<div class="sub-menu-inner">
									<div>
										<h4>Q&A</h4>
										<ul>
											<li><a href="">직무/진로</a></li>
											<li><a href="">스펙평가</a></li>
											<li><a href="">연봉/복지</a></li>
											<li><a href="">서류/지소서</a></li>
										</ul>
									</div>
									<div>
										<h4>Belajar2</h4>
										<ul>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
											<li><a href="">Web</a></li>
										</ul>
									</div>

								</div>
							</div></li>




					</ul>

				</nav>
			</div>
		</div>


		<hr>

		<script
			src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/jquery.min.js"></script>
		<script
			src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/dropdownmenu.min.js"></script>

		<script>
		
		dropdownmenu.init();
		
		</script>