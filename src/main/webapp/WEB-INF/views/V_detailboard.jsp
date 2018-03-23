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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<style type="text/css">
.content {
	border: 1px solid gray;
	height: auto;
	width: 100%;
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
					var textarea = document.createElement("textarea");
										
					textarea.setAttribute("style","background-color:#F2F2F2;");	
					textarea.setAttribute("cols", "100");
					textarea.setAttribute("rows","5");
					textarea.setAttribute("readonly","readonly");
					
					
					textarea.textContent=lists[i].r_content; //textarea는 innerHTML 안되더라..
					td2.innerHTML ="<a href='deletecomment.do?r_seq="+lists[i].r_seq+"&a_seq="+lists[i].a_seq+"'>삭제</a>";
					td3.innerHTML ="<a href='#'>수정</a>";
					
					td.appendChild(textarea); //<td><textarea>lists[i].r_content</textarea> </td>
					
					tr.appendChild(td);//<tr><td><textarea>lists[i].r_content</textarea></td></tr>
					tr.appendChild(td2);
					tr.appendChild(td3);
					replyTable.appendChild(tr); 
					
					
			
				 	}
					
			}
	
		}); 

	}
	//나중에 Session에 담겨진 것들로 리플라이 파라미터 값(a_unum)을 넣어야한다
	//***좋아요 ajax는 나중에 로그인이랑 합쳐지면 다시 수정해보자
	function like(seq,unum) {
		
		
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
				else{
					
				}
							
				//여기서 받아온 최대값으로 기존에 좋아요를 바꾸면 되겠다.
							
				
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

	<div class="content">

		

		<div id="container">
			<table>
				<tr>
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
					<!-- dto.a_unum값이 아니라 나중에 Session에 담겨진 것들로 파라미터 값(a_unum)을 넣어야한다.  -->
					<td><button onclick="like(${dto.a_seq},'${dto.a_unum}')">좋아요버튼</button>
					</td>

					<!-- 나중에 dto.a_unum값이 아니라 나중에 Session에 담겨진 것들로 파라미터 값(a_unum)을 넣어야한다.  -->

					<td><button
							onclick="location.href='searchlike.do?a_seq=${dto.a_seq}'">즐겨찾기</button></td>


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
									onclick="reply(${dto.a_seq},'${dto.a_unum}','${dto.a_boardname}')">등록</button></td>

							<!-- 여기서 dtos.r_seq값을 전달해야하는데 어찌 전달하지 ... -->

						</tr>

					</c:when>

					<c:otherwise>
						<tr>
							<td><textarea rows="5" cols="100" class="context"></textarea>

								<!--나중에 Session에 담겨진 것들로 리플라이 파라미터 값(a_unum)을 넣어야한다.  -->
								<button
									onclick="reply(${dto.a_seq},'${dto.a_unum}','${dto.a_boardname}')">등록</button>

							</td>

						</tr>

						<!--사용자의 a_num과 게시판의 dto.a_num이 같아야지 삭제버튼이 생기도록하기위해서
						U49대신 나중에 사용자의 a_num을 추가시켜줘야한다. -->

						<c:choose>
							<c:when test="${'U49'eq dto.a_unum}">

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
					<td><button onclick="location.href='replyboard.do?a_seq=${dto.a_seq}'">답글</button></td>
					
					<c:choose>

						<c:when test="${'U49' eq dto.a_unum}">
							
							<td><button onclick="location.href='moveupdateboard.do?a_seq=${dto.a_seq}'">수정</button> </td>
							<td><button	onclick="location.href='deleteboard.do?a_seq=${dto.a_seq}'">삭제</button></td>

						</c:when>


					</c:choose>
					<td><button onclick="location.href='V_Board.do'">목록</button></td>
					
				</tr>

			</table>

		</div>

	</div>

</body>
</html>