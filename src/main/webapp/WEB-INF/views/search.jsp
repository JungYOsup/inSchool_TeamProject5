<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style type="text/css">


#tr01{background:orange; text-align:center;}
td{text-align:center;}
</style>






</head>




<body>

<jsp:include page="header01.jsp"/>





<table>
<col width="100px">
<col width="200px">
<col width="400px">
<col width="150px">


<tr id="tr01">
<td>작성자</td>
<td>글제목</td>
<td>내용</td>
<td>작성일</td>
</tr>


<c:choose>

<c:when test="${empty lists}">

<tr><td colspan="4">-----------------------------------------------검색어와 관련된 글이 없습니다.------------------------------------------------</td></tr>

</c:when>

<c:otherwise>

<c:forEach items="${lists}" var="dto">

<tr>
<td>${dto.a_name}</td>
<td>${dto.a_title}</td>
<td>${dto.a_content1}</td>
<td>${dto.a_regdate}</td>
</tr>



</c:forEach>

</c:otherwise>

</c:choose>


<c:choose>

<c:forEach begin="0" end="" step="1" var="" items="">


</c:forEach>

</c:choose>





</table>


<script type="text/javascript">


 $("br").remove(); 
 	
 
 
// 자바스크립트는 꼭 배열안에 것들을 꺼내줘야 된다

// 	var brs = document.getElementsByTagName("br")

// 	for (var i = 0; i < brs.length; i++) {
		
		
// 	brs[i]
	

// 	};

	

</script>




</body>
</html>