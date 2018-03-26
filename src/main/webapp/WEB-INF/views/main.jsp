<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">




<title>Insert title here</title>


<!--  <meta name="author" content="Codrops" /> -->
<!--         <link rel="shortcut icon" href="../favicon.ico">  -->
<!--         <link rel="stylesheet" type="text/css" href="css/demo.css" /> -->
 			<link rel="stylesheet" type="text/css" href="css/style.css" />
<!-- 		<script type="text/javascript" src="js/modernizr.custom.04022.js"></script> -->
<!-- 		<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic' rel='stylesheet' type='text/css'> -->


<style type="text/css">

/* .container{position:relative;} */

.title{width:400px; height:100px; text-align:center; background:yellow;}

td{border:none; }

input{width:100%;}

/*  #imgContainer{position:relative; width: 1000px; height:320px; margin:0,auto; left:300px; border:1px solid black; overflow:hidden;} */

  img{width:100%; height:100%;}

/* img{width:200px; height:100px;} */
/* relative 준 놈이 기준이 된다 */

 #postborder{position:relative; width: 1000px; height: 1000px; margin:0,auto; top:50px;}

#table01{position:absolute; left:380px;}


#table02{position:absolute; left:785px;}


#table03{position:absolute; left:380px; top:370px;}


#table04{position:absolute; left:785px; top:370px;}

</style>




</head>
<body>
<jsp:include page="header01.jsp"/>

        <div class="container">
			
			
			<div class="sp-slideshow">
			
				<input id="button-1" type="radio" name="radio-set" class="sp-selector-1" checked="checked" />
				<label for="button-1" class="button-label-1"></label>
				
				<input id="button-2" type="radio" name="radio-set" class="sp-selector-2" />
				<label for="button-2" class="button-label-2"></label>
				
				<input id="button-3" type="radio" name="radio-set" class="sp-selector-3" />
				<label for="button-3" class="button-label-3"></label>
				
				<input id="button-4" type="radio" name="radio-set" class="sp-selector-4" />
				<label for="button-4" class="button-label-4"></label>
				
<!-- 				<input id="button-5" type="radio" name="radio-set" class="sp-selector-5" /> -->
<!-- 				<label for="button-5" class="button-label-5"></label> -->
				
				
							<!-- 애로우 (화살표) -->
				<label for="button-1" class="sp-arrow sp-a1"></label>
				<label for="button-2" class="sp-arrow sp-a2"></label>
				<label for="button-3" class="sp-arrow sp-a3"></label>
				<label for="button-4" class="sp-arrow sp-a4"></label>
<!-- 				<label for="button-5" class="sp-arrow sp-a5"></label> -->
				
				<div class="sp-content">
<!-- 					<div class="sp-parallax-bg"></div> -->
					<ul class="sp-slider clearfix">
						<li><img src="images/img01.jpg" alt="image01" /></li>
						<li><img src="images/img02.jpg" alt="image02" /></li>
						<li><img src="images/img03.jpg" alt="image03" /></li>
						<li><img src="images/img.png" alt="image04" /></li>
<!-- 						<li><img src="images/image5.png" alt="image05" /></li> -->
					</ul>
				</div>
				
			</div>
			
		</div>




<div id ="postborder">

<table id="table01">
<tr><td class="title">이력서게시판</td></tr>

<c:choose>
<c:when test="${empty listResume}">

<tr><td>---------------작성된 글이 없습니다----------------</td></tr>

</c:when>
<c:otherwise>

<c:forEach items="${listResume}" var="dto1">
<tr><td>${dto1.a_title}</td></tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>

<table id="table02">
<tr><td class="title">면접게시판</td></tr>

<c:choose>
<c:when test="${empty listInter}">

<tr><td>---------------작성된 글이 없습니다----------------</tr></td>

</c:when>
<c:otherwise>

<c:forEach items="${listInter}" var="dto2">

<tr><td>${dto2.a_title}</td></tr>
</c:forEach>
</c:otherwise>
</c:choose>

</table>

<table id="table03">

<tr><td class="title">자유게시판</td></tr>
<c:choose>

<c:when test="${empty listFree}">

<tr><td>---------------작성된 글이 없습니다----------------</tr></td>

</c:when>
<c:otherwise>


<c:forEach items="${listFree}" var="dto3">

<tr><td>${dto3.a_title}</td></tr>
</c:forEach>

</c:otherwise>
</c:choose>

</table>

<table id="table04">

<tr><td class="title">질문게시판</td></tr>


<c:choose>

<c:when test="${empty listQA}">

<tr><td>---------------작성된 글이 없습니다----------------</tr></td>

</c:when>
<c:otherwise>

<c:forEach items="${listQA}" var="dto4">

<tr><td>${dto4.a_title}</td></tr>
</c:forEach>
</c:otherwise>
</c:choose>

</table>
</div>




</body>
</html>