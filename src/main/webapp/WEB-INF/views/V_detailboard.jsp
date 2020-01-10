
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html; charset=utf-8");
%>




<!DOCTYPE html>


<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<style type="text/css">
.content {
	border: 1px solid gray;
	height: auto;
	width: 100%;
}

textarea {
	width: 800px;
	height: 50px;
}

#registButton{
	margin-left: 10px;
	width: 66px;
	height: 50px;
}
</style>
<script type="text/javascript">

	/* 넘겨 받아야할 값들이 게시판이름 , 회원번호 , 게시판번호 , 글내용,  */
	function reply(seq,unum,boardname) {
		
		var content = $(".context").val(); //textaread값은 val로 값을 가진다.
		
			$.ajax({
				url:"CommentAjax.do",
				data:"r_content="+content+"&r_unum="+unum+"&a_seq="+seq+"&r_boardname="+boardname,
				type: "post",
				datatype:"json",
				success: function name(obj) {
										
					
			 var lists = obj["lists"];
			 
			 	/* deletecomment.do?r_seq=${dtos.r_seq}&a_seq=${dto.a_seq} */
				 
			 				 			
			 			
			 	for (var i = lists.length-1; i < lists.length; i++) {
				 				 
			 		var tr = document.createElement("tr");
					var td = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var td4 = document.createElement("td");
					var textarea = document.createElement("textarea");
									
					
									
					textarea.setAttribute("style","background-color:#F2F2F2;");	
					textarea.setAttribute("cols", "100");
					textarea.setAttribute("rows","5");
					textarea.setAttribute("readonly","readonly");
					
					textarea.textContent=lists[i].r_content; //textarea는 innerHTML 안되더라..
					td2.innerHTML ="<a href='deletecomment.do?r_seq="+lists[i].r_seq+"&a_seq="+lists[i].a_seq+"'>삭제</a>";
					td3.innerHTML ="<a href='#'>수정</a>";
					td4.innerHTML =lists[i].r_unum;
					
					td.appendChild(textarea); //<td><textarea>lists[i].r_content</textarea> </td>
					
					tr.appendChild(td);//<tr><td><textarea>lists[i].r_content</textarea></td></tr>
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td4);
					
					replyTable.appendChild(tr); 
					
					
			
				 	}
					
			}
	
		}); 

	}
	//나중에 Session에 담겨진 것들로 리플라이 파라미터 값(a_unum)을 넣어야한다
	//***좋아요 ajax는 나중에 로그인이랑 합쳐지면 다시 수정해보자
	function like(seq,unum,f_like) {
		
		
		$.ajax({
			
			url: "likeboard.do",
			data:"a_seq="+seq+"&a_unum="+unum,
			type: "post",
			datatype: "json",
			success: function name(result) {
				
				var result = result["f_saveorlike"]; 
				
				
				if(result !=null){
					
					$("#likeup").html("좋아요"+result.f_like); 
					
				}
							 
				if(result==null&&f_like=='0'){
					
					$("#likeup").html("좋아요"+(f_like));
					
				}else if(result==null){
					$("#likeup").html("좋아요"+(f_like));
					
				}
				
				
											
							
				
			}
						
		});
		
		
	}
	
	
	
</script>

<link href="http://vjs.zencdn.net/c/video-js.css" rel="stylesheet" />
<script src="http://vjs.zencdn.net/c/video.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div class="container">

		<jsp:include page="header.jsp"></jsp:include>

		<div class="row">

			<!--게시판 선택리스트공간 -->
			<div class="col-xs-2">


				<!--리스트가 생길때마다 추가시켜주기만 추가시켜주기만 하면됨 -->
				<c:choose>
					<c:when
						test="${dto.a_boardname eq 'CV' || dto.a_boardname eq 'UV' }">

						<table>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=UV">유저동영상</a></td>
							</tr>
							<tr>
								<td><a onclick="aa('${user.j_grade}')">기업동영상</a></td>
							</tr>

						</table>
					</c:when>



				</c:choose>

				<c:choose>
					<c:when test="${dto.a_boardname eq 'IN'}">

						<table>
							<tr>
								<td><a href="#">사이트 소개</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=IN">공지사항</a></td>
							</tr>

						</table>
					</c:when>



				</c:choose>

				<c:choose>
					<c:when
						test="${dto.a_boardname eq 'HOT'|| dto.a_boardname eq 'AF' }">

						<table>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=HOT">면접준비
										이슈사항</a></td>
							</tr>
							<tr>
								<td><a href="Calendarform.do?a_boardname=CD">공채일정달력</a></td>
							</tr>
							<tr>
								<td><a href="comjob.do?a_boardname=CI">기업채용 기간정보</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=AF">기업면접
										후기</a></td>
							</tr>
						</table>
					</c:when>



				</c:choose>

				<c:choose>
					<c:when
						test="${dto.a_boardname eq 'PE_INFO'|| dto.a_boardname eq 'MAJOR_INFO' || dto.a_boardname eq 'MID_INFO'|| dto.a_boardname eq 'SMALL_INFO'  }">

						<table>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=PE_INFO">공기업
										면접정보</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=MAJOR_INFO">대기업
										면접정보</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=MID_INFO">중견기업
										면접정보</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=SMALL_INFO">중소기업
										면접정보</a></td>
							</tr>
						</table>
					</c:when>



				</c:choose>


				<c:choose>
					<c:when
						test="${dto.a_boardname eq 'Book_LIST'|| dto.a_boardname eq 'Book_Annotation' }">

						<table>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=Book_LIST">자소서항목</a></td>
							</tr>
							<tr>
								<td><a
									href="Boardname_boardlist.do?a_boardname=Book_Annotation">자소서첨삭</a></td>
							</tr>
						</table>
					</c:when>



				</c:choose>

				<c:choose>
					<c:when
						test="${dto.a_boardname eq 'Pass_spec'|| dto.a_boardname eq 'Pass_Book' }">

						<table>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=Pass_spec">합격스펙</a></td>
							</tr>
							<tr>
								<td><a href="Boardname_boardlist.do?a_boardname=Pass_Book">합격자소서</a></td>
							</tr>
						</table>
					</c:when>



				</c:choose>


			</div>


			<!--게시판 출력 공간-->
			<div class="col-xs-10">

				<div class="content">

					<div id="container">
						<table border="1" style="width: 943px;" class=".table-hover">

							<tr>
								<th>제목</th>
								<td>${dto.a_option}${dto.a_title}</td>

							</tr>

							<c:choose>

								<c:when test="${'0' ne dto.v_oriname}">
									<!--기본 등록되는 값이 0이기 때문에 dto.v_oriname =0이 아닐경우 즉 동영상이 있을경우 동영상창을 띄우고  '0'이 아닌 0 으로 하면 안되는 이유가 value값에 String type으로 들어가기 때문이다. -->

									<tr>
										<th>내용</th>
										<td><video width="640" height="360" controls="controls"
												class="video-js vjs-default-skin" data-setup="{}">

												<source src="/inschool/upload/board/files/${dto.v_oriname}"
													type="video/mp4">

											</video> ${dto.a_content1}</td>
									</tr>

								</c:when>

								<c:otherwise>
									<!--그렇지 않고 0 일경우에는 내용을 띄운다 -->
									<tr>
										<th>내용</th>
										<td>${dto.a_content1}</td>
									</tr>

								</c:otherwise>
							</c:choose>

							<tr>
								<th>이름</th>
								<td>${dto.a_name}</td>
							</tr>
						</table>

					</div>

					<div class="func">


						<table>
							<!--나중에 좋아요 버튼에 그림 입히자 -->
							<tr>
								<td>댓글${dto.a_ansnum}</td>
								<td>등록순</td>
								<td>조회수${dto.a_recount}</td>
								<td id="likeup">좋아요${dto.funtion_T_Dtos.f_like}</td>

								<c:choose>

									<c:when test="${user.j_comnum eq '0'}">

										<td><button
												onclick="like(${dto.a_seq},'${user.j_unum}',${dto.funtion_T_Dtos.f_like} )">좋아요버튼</button></td>

										<td><button
												onclick="location.href='searchlike.do?a_seq=${dto.a_seq}&a_unum=${user.j_unum}'">즐겨찾기</button></td>


									</c:when>

								</c:choose>


								<!-- 나중에 dto.a_unum값이 아니라 나중에 Session에 담겨진 것들로 파라미터 값(a_unum)을 넣어야한다.  -->



								<!--사용자의 a_num과 게시판의 dto.a_num이 같아야지 삭제버튼이 생기도록하기위해서
					U49대신 나중에 사용자의 a_num을 추가시켜줘야한다. -->




							</tr>
						</table>

					</div>

					<div class="reply">

						<table id="replyTable">

							<c:choose>
								<c:when test="${empty lists}">

									<tr>

										<td><textarea rows="5" cols="100" class="context"></textarea></td>
										<!--나중에 Session에 담겨진 것들로 리플라이 파라미터 값(a_unum)을 넣어야한다.  -->
										<td><button
												onclick="reply(${dto.a_seq},'${user.j_unum}','${dto.a_boardname}')">등록</button></td>

										<!-- 여기서 dtos.r_seq값을 전달해야하는데 어찌 전달하지 ... -->

									</tr>

								</c:when>

								<c:otherwise>
									<tr>
										<td><textarea rows="5" cols="100" class="context"></textarea>

											<!--나중에 Session에 담겨진 것들로 리플라이 파라미터 값(a_unum)을 넣어야한다.  --></td>
										<td>
											<button id="registButton"
												onclick="reply(${dto.a_seq},'${user.j_unum}','${dto.a_boardname}')" style="">등록</button>
										</td>
									</tr>
									<!--사용자의 a_num과 게시판의 dto.a_num이 같아야지 삭제버튼이 생기도록하기위해서
						U49대신 나중에 사용자의 a_num을 추가시켜줘야한다. -->
									<c:choose>
										<c:when test="${user.j_unum eq dto.a_unum}">
											<c:forEach items="${lists}" var="dtos">
												<tr>
													<td><textarea rows="5" cols="100" readonly="readonly"
															style="background-color: #F2F2F2">${dtos.r_content}</textarea></td>
													<td><a
														href="deletecomment.do?r_seq=${dtos.r_seq}&a_seq=${dto.a_seq}">삭제</a></td>
													<td><a href="#">수정</a></td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:forEach items="${lists}" var="dtos">
												<tr>
													<td><textarea rows="5" cols="100" readonly="readonly"
															style="background-color: #F2F2F2">${dtos.r_content}</textarea></td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</table>
						<table>


							<tr>
								<td><button
										onclick="location.href='replyboard.do?a_seq=${dto.a_seq}'">답글</button></td>

								<c:choose>

									<c:when test="${user.j_unum eq dto.a_unum}">

										<td><button
												onclick="location.href='moveupdateboard.do?a_seq=${dto.a_seq}'">수정</button>
										</td>
										<td><button
												onclick="location.href='deleteboard.do?a_seq=${dto.a_seq}&a_boardname=${dto.a_boardname}'">삭제</button></td>

									</c:when>


								</c:choose>
								<td><button
										onclick="location.href='Boardname_boardlist.do?a_boardname=${dto.a_boardname}'">목록</button></td>
								<c:choose>
									<c:when
										test="${user.j_comnum ne '0' && dto.a_boardname eq 'CV' }">


										<td><button
												onclick="location.href='recommend.do?a_seq=${dto.a_seq}&a_comnum=${user.j_comnum}&a_unum=${dto.a_unum}'">추천</button></td>
									</c:when>


								</c:choose>



							</tr>

						</table>

					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>