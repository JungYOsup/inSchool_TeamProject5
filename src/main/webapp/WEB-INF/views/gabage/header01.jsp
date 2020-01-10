<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8");%> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">




<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-lastest.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<script type="text/javascript">

$(function() {
	
	
	$(".hide01").hide();
	
	$(".menu").click(function() {
		
		$(this).children("div").slideToggle();
		
		$(this).siblings().children("div").hide();
		
// 		$(this).parents("#container").children("div").siblings().children(".hide01").hide();
		
// 		$("#container").children(".menu").siblings().find(".hide01").hide();
		
	});
	
// 	$.ajax({
// 		url:"http://api.saramin.co.kr/job-search",
// // 		data:"keywords=웹+퍼블리셔",
// 		datatype:"xml",
// 		success:function(doc){
// 			alert($(doc).find("keyword").eq(0).text());
// 		},
// 		error:function(){
// 			alert("실패");
// 		}
// 	});
});

</script>

<style type="text/css">


#container01{width:100%; height:400px;}

#top01{height:100px; position:relative; font:300px; text-align:center; width:100%; background:aqua;}

#topTitle{color:white; position:absolute; left:300px; text-align: center; padding:30px; font-size:30px; font-color:black;}

#topSearch{position:absolute; left:600px;}

.search01{left:600px;}

.submit01{left:700px;}


a{text-decoration:none;}

.menu{width:120px; position:absolute; text-align:center; color:black; top:120px;}

#menu01{left:200px;}

#menu02{left:400px;}

#menu03{left:600px;}

#menu04{left:800px;}

#menu05{left:1000px;}

#menu06{left:1200px;}

 #menu07{left:1400px;}

/* #menu08{left:400px;} */

</style>

</head>

<body>

<div id="container01">

<div id="top01">

<div id="topTitle">면접 학교</div>

<div id="topSearch">

<form action="search00.do" method="post">
<table>
<tr>
<td>
<select style="height:25px;" name="select01">
<option value="searchAllinfo">전체검색</option>
<option value="titleOnly">제목만</option>
<option value="writer">작성자</option>
</select>
</td>
<td><input type="text" placeholder="검색어를 넣어주세요" name="word" style="width:250px; height:20px;"/></td>
<td><input type="submit" value="검색"/></td>
</tr>
</table>
</form>

<!-- topSearch -->
</div>

<!-- top01 -->
</div>

<div id="menues">
<div id="menu01" class="menu">

<a href="#">소개</a>

<div class="hide01">
<a href="#">커뮤니티소개</a>
<br/>
<a href="#">기업소개</a>
<br/>
<a href="#">추천기업소개</a>
</div>

</div>


<div id="menu02" class="menu">

<a href="#">동영상</a>

<div class="hide01">
<a href="#">개인면접동영상</a>
<br/>
<a href="#">기업동영상</a>
<br/>
<a href="#">????</a>
</div>
</div>

<div id="menu03" class="menu">

<a href="#">면접게시판</a>

<div class="hide01">
<a href="#">면접꿀팁공유</a>
<br/>
<a href="#">??</a>
<br/>
<a href="#">??</a>
</div>
</div>

<div id="menu04" class="menu">

<a href="#">이력서게시판</a>

<div class="hide01">
<a href="#">꿀팁공유</a>
<br/>
<a href="#">이력서첨삭</a>
<br/>
<a href="#">합격이력서</a>
</div>
</div>

<div id="menu05" class="menu">

<a href="#">학습게시판</a>

<div class="hide01">
<a href="#">면접자료</a>
<br/>
<a href="#">이력서자료</a>
<br/>
<a href="#">???</a>
</div>
</div>

<div id="menu06" class="menu">

<a href="#">자유게시판</a>

<div class="hide01">
<a href="#">일상대화</a>
<br/>
<a href="#">면접경험담</a>
<br/>
<a href="#">기타</a>
</div>
</div>
<div id="menu07" class="menu">

<a href="#">Q&A</a>

<div class="hide01">
<a href="#">면접Q&A</a>
<br/>
<a href="#">이력서Q&A</a>
<br/>
<a href="#">기타</a>
</div>
</div>

</div>

</div>

</body>
</html>