<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			 
			 
			 for (var i = lists.length-1; i < lists.length; i++) {
				 				 
				var tr = document.createElement("tr");
				var td = document.createElement("td");
				var textarea = document.createElement("textarea");
				
				
				textarea.setAttribute("cols", "100");
				textarea.setAttribute("rows","5");
				
				textarea.textContent=lists[i].r_content; //textarea는 innerHTML 안되더라..
				
				td.appendChild(textarea); //<td><textarea>lists[i].r_content</textarea> </td>
				
				tr.appendChild(td);//<tr><td><textarea>lists[i].r_content</textarea></td></tr>
											
				replyTable.appendChild(tr); 
				
							
									
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

	<div class="content">

		<div class="title">

			<table>

				<tr>
					<td>[한국수력원자력]</td>
					<td>타이틀</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>날짜</td>
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
					<td>좋아요${dto.funtion_T_Dtos.f_like}</td>
					<td><button
							onclick="location.href='likeboard.do?a_seq=${dto.a_seq}'"></button>
					</td>
				</tr>
			</table>

		</div>


		<div class="reply">

			<table id="replyTable">

				<c:choose>
					<c:when test="${empty lists}">

						<tr>

							<td><textarea rows="5" cols="100" class="context"></textarea></td>

							<td><button onclick="reply(${dto.a_seq},'${dto.a_unum}','${dto.a_boardname}')">등록</button></td>

						</tr>

					</c:when>

					<c:otherwise>
						<tr>
								<td><textarea rows="5" cols="100" class="context"></textarea>


									<button onclick="reply(${dto.a_seq},'${dto.a_unum}','${dto.a_boardname}')">등록</button>

								</td>




						</tr>
						
						<c:forEach items="${lists}" var="dtos" >

							<tr>
								<td><textarea rows="5" cols="100" readonly="readonly">${dtos.r_content}</textarea></td>
							</tr>
							

						</c:forEach>
						
						



					</c:otherwise>


				</c:choose>

			</table>





		</div>







	</div>


<%-- <div id="container">
<h2>상세보기</h2>
<table class="table table-striped">
	<tr>
		<th>번호</th>
		<td>${dto.a_seq}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${dto.a_title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><video width="640" height="360" controls="controls" class="video-js vjs-default-skin" data-setup="{}">
		<source	src="/inschool/upload/board/files/${dto.v_oriname}" type="video/mp4"></video>
		
		${dto.a_content1}
		
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${dto.a_name}</td>
	</tr>
</table>

</div> --%>





</body>
</html>