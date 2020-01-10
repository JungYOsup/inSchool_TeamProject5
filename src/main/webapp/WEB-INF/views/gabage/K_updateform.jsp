<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
		$(function(){
			$("#passch").hover(function () {
				$("#password").attr("type","text");
			},function(){
				$("#password").attr("type","password");
			})
		}); 
</script>		
</head>
<body>
<form action="updateinform.do" method="post">
<c:choose>
<c:when test="${udto empty}">
	 <input type="hidden" name="j_seq" value="${udto.j_seq}"> 
<table>
      <tr>
      	<td>
      	 	<table id="table1">
      	 	   <tr>
      	  	   <td colspan="2"><input type="text" name="j_name" value="${udto.j_name}" id="name" /></td>
      	  	   </tr>
      	  		<tr>
      	  		<td><input type="text" name="j_id" value="${udto.j_id}" id="id" readonly="readonly"></td>
      	  		</tr>	
      	  	</table>	
      	</td>
      	<td>
      	    <table>
      	      <tr>
      	       	 <th>비밀번호*</th>
      	       	 <td>
      	       	 <input type="password"	 name="j_pass"  id="password" value="${udto.j_pass}">
      	       	 <input type="button" value="비밀번호확인" id="passch" onclick="pwch()">
      	       	 </td>	
      	      </tr>
      	      <tr>
      	       	 <th>생년월일*</th>
      	       	 <td><input type="text" name="j_birth" value="${udto.j_birth}"  id="birthday" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>주소*</th>
      	       	 <td><input type="text"  value="${udto.j_addr }" name="j_addr"   id="address" ></td>	
      	      </tr>
      	      <tr>
      	      	 <th></th>
      	         <td><input type="text" value="${udto.j_deaddr}"  name="j_deaddr"  id="Daddress"/></td>
      	      </tr>
      	       <tr>
      	       	 <th>우편번호*</th>
      	       	 <td><input type="text" name="j_post" value="${udto.j_post}"  id="address" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>전화번호*</th>
      	       	 <td><input type="text" name="j_tel" value="${udto.j_tel}"  id="tel" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>이메일*</th>
      	       	 	<td>
      	       	 		<input type="text" name="j_email"  value="${udto.j_email}" id="email" >
<!-- 						<select name="kind of email"> -->
<!-- 							<option value="back of email">이메일 입력</option> -->
<!-- 							<option value="naver" >naver.com</option> -->
<!-- 							<option value="google" >google.com</option> -->
<!-- 							<option value="daum" >daum.net</option> -->
<!-- <!-- 							<option value="free" id="option" >직접입력</option> --> 
<!-- 						</select>      	       	 	 -->
      	       		 </td>	
      	      </tr>
      	      <tr>
      	      	<th>직종</th>
      	      	<td>
					<input type="text" id="job" value="${udto.j_job}" name="j_job" />      	      	
      	      	</td>
      	      </tr>
      	      <tr>
      	      	<th>유저번호</th>
      	      	<td>
					<input type="text" id="unum" value="${udto.j_unum}" name="j_unum" readonly="readonly" />      	      	
      	      	</td>
      	      </tr>
<!--       	       <tr> -->
<!--       	       	 <th>성별*</th> -->
<!--       	       	 <td> -->
<!--       	       	 <input type="radio" id="female" name="female" value="gilr"/>여자 -->
<!--       	       	 <input type="radio" id="male" name="male" value="Man"/>남자 -->
<!--       	       	 </td> -->
<!--       	      </tr> -->
      	    </table>
      	</td>
      </tr>
	</table>
	 	 <input type="submit" value="수정완료" style="text-align: right;">
	 	 <input type="button" value="회원탈퇴" onclick="deleteId(${udto.j_seq})">
</c:when>
<c:otherwise>
 <input type="hidden" name="j_seq" value="${udto.j_seq}"> 
<table>
      <tr>
      	<td>
      	 	<table id="table1">
      	 	   <tr>
      	  	   <td colspan="2"><input type="text" name="j_name" value="${udto.j_name}" id="name" /></td>
      	  	   </tr>
      	  		<tr>
      	  		<td><input type="text" name="j_id" value="${udto.j_id}" id="id" readonly="readonly"></td>
      	  		</tr>	
      	  	</table>	
      	</td>
      	<td>
      	    <table>
      	      <tr>
      	       	 <th>비밀번호*</th>
      	       	 <td>
      	       	 <input type="password"	 name="j_pass"  id="password" value="${udto.j_pass}">
      	       	 <input type="button" value="비밀번호확인" id="passch" onclick="pwch()">
      	       	 </td>	
      	      </tr>
      	      <tr>
      	       	 <th>생년월일*</th>
      	       	 <td><input type="text" name="j_birth" value="${udto.j_birth}"  id="birthday" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>주소*</th>
      	       	 <td><input type="text"  value="${udto.j_addr }" name="j_addr"   id="address" ></td>	
      	      </tr>
      	      <tr>
      	      	 <th></th>
      	         <td><input type="text" value="${udto.j_deaddr}"  name="j_deaddr"  id="Daddress"/></td>
      	      </tr>
      	       <tr>
      	       	 <th>우편번호*</th>
      	       	 <td><input type="text" name="j_post" value="${udto.j_post}"  id="address" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>전화번호*</th>
      	       	 <td><input type="text" name="j_tel" value="${udto.j_tel}"  id="tel" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>이메일*</th>
      	       	 	<td>
      	       	 		<input type="text" name="j_email"  value="${udto.j_email}" id="email" >
<!-- 						<select name="kind of email"> -->
<!-- 							<option value="back of email">이메일 입력</option> -->
<!-- 							<option value="naver" >naver.com</option> -->
<!-- 							<option value="google" >google.com</option> -->
<!-- 							<option value="daum" >daum.net</option> -->
<!-- <!-- 							<option value="free" id="option" >직접입력</option> --> 
<!-- 						</select>      	       	 	 -->
      	       		 </td>	
      	      </tr>
      	      <tr>
      	      	<th>직종</th>
      	      	<td>
					<input type="text" id="job" value="${udto.j_job}" name="j_job" />      	      	
      	      	</td>
      	      </tr>
      	      <tr>
      	      	<th>유저번호</th>
      	      	<td>
					<input type="text" id="unum" value="${udto.j_unum}" name="j_unum" readonly="readonly" />      	      	
      	      	</td>
      	      </tr>
<!--       	       <tr> -->
<!--       	       	 <th>성별*</th> -->
<!--       	       	 <td> -->
<!--       	       	 <input type="radio" id="female" name="female" value="gilr"/>여자 -->
<!--       	       	 <input type="radio" id="male" name="male" value="Man"/>남자 -->
<!--       	       	 </td> -->
<!--       	      </tr> -->
      	    </table>
      	</td>
      </tr>
	</table>
	 	 <input type="submit" value="수정완료" style="text-align: right;">
	 	 <input type="button" value="회원탈퇴" onclick="deleteId(${udto.j_seq})">
	 	 </c:otherwise>
	</c:choose>
	</form>
</body>
</html>