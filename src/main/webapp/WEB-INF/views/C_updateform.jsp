<%@page import="com.min.inschool.dtos.Join_T_Dtos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %> 
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">
    /* #table1{border: 1px solid; width: 500px; height: 500px;}
	.hi{border: none; border-left: 0px; border-right: 0px; border-top: 0px; border-bottom: 0px;} */
	#id{border: none; border-left: 0px; border-right: 0px; border-top: 0px; border-bottom: 0px; text-align: center;}
	#name{text-align: center; width: 150px; height: 60px; font-size: 13pt;}
	#table1{border: none; border-left: 0px; border-right: 0px; border-top: 0px; border-bottom: 0px; text-align: center;
	       ;
	}
/*     #tr{display: none; }     */
	

</style>
<script type="text/javascript">
		$(function(){
			$("#passch").hover(function () {
				$("#password").attr("type","text");
			},function(){
				$("#password").attr("type","password");
			})
		})  //비밀번호  확인하는 스크립트 쿼리

// 		$(function () {
// 			$("#option").onclick(function () {
// 				$("#option").attr("type","text");
// 			})
// 		})
		
		function deleteId(seq) {
			location.href="deleteId.do?seq="+seq;
		};
		
</script>
</head>
<body>
<form action="updateinform.do" method="post">
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
      	       	 <input type="password" value="${udto.j_pass}" name="j_pass"  id="password">
      	       	 <input type="button" value="비밀번호확인" id="passch" onclick="pwch()">
      	       	 </td>	
      	      </tr>
      	      <tr>
      	       	 <th>생년월일*</th>
      	       	 <td><input type="text" name="j_birth" value="${udto.j_birth}"  id="birthday" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>주소*</th>
      	       	 <td><input type="text" name="j_addr" value="${udto.j_addr}"  id="address" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th></th>
      	       	 <td><input type="text" name="j_deaddr" value="${udto.j_deaddr}"  id="address" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>우편번호*</th>
      	       	 <td><input type="text" name="j_post" value="${udto.j_post}"  id="post" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>전화번호*</th>
      	       	 <td><input type="text" name="j_tel" value="${udto.j_tel}"  id="tel" ></td>	
      	      </tr>
      	       <tr>
      	       	 <th>이메일*</th>
      	       	 	<td>
      	       	 		<input type="text" name="j_email"  id="email" value="${udto.j_email}" >
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
      	       	 <th>직종*</th>
      	       	 <td><input type="text" name="j_job" value="${udto.j_job}"  id="job" ></td>	
      	      </tr>
      	      <tr>
      	      	<th>회사번호</th>
      	      	<td>
					<input type="text" id="com" value="${udto.j_comnum}" name="j_comnum" readonly="readonly" />      	      	
      	      	</td>
      	      </tr>
      	    </table>
      	</td>
      </tr>
	</table>
	 	 <input type="submit" value="수정완료" style="text-align: right;">
	 	 <input type="button" value="회원탈퇴" onclick="deleteId(${udto.j_seq})" >
	</form>
</body>
</html>