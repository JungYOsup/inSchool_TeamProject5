<%@page import="com.min.inschool.daos.regist_daos"%>
<%@page import="com.min.inschool.dtos.Join_T_Dtos"%>
<%@page import="org.springframework.mail.MailMessage"%>
<%@page import="com.min.inschool.LoController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 창</title>
<style type="text/css">
th {
	text-align: center;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<jsp:include page="email_daum.jsp"></jsp:include>

<script type="text/javascript">
	//아이디중복확인
	function chkDupId() {
		var prmId = $('#insertId').val();
		if(prmId==''){
			$('#idid').html('ID를 입력해주세요!!');
		}else if(!(prmId>='0'&&prmId<='9'||prmId>='a'&&prmId<='z')){
			$('#idid').html('숫자와 영어소문자만 사용해주세요.');
		}else{
			$.ajax({
				type:'POST',
				data:"j_id="+prmId,
				dataType:'text',
				url:'chkDupId.do',
				success:function(rData,textStatus,xhr){
					var chkRst=rData;
					if(chkRst==0){
						$('#idid').html('가입 가능한 ID 입니다.');
						$("#idChk").val('Y');
					}else{
						$('#idid').html('중복된 ID 입니다.');
						$("#idChk").val('N');
						}
					},
					error:function(xhr,status,e){
						alert(e);
					}
				});
			}
					return;
		}
	
	//비밀번호 확인
	function passchk() {
		var pass1=$("#pass1").val();
		var pass2=$("#pass2").val();
		if (pass1!=pass2) {
			$('#passmessage').html('미일치');
		} else {
			$('#passmessage').html('일치');
		}
	}
	//비밀번호 password 기능에서 확인 기능에 hover
		$(function () {
			$("#pass2").hover(function () {
				$("#pass1").attr("type","text");
				$("#pass2").attr("type","text");
			},function(){
				$("#pass1").attr("type", "password");
				$("#pass2").attr("type", "password");
			})			
		})
  	//이름 제약조건
  	function nam() {
	  	var na = $('#na1').val();
	  	if(na==''){
	  		$('#na2').html('이름을 입력해주세요.')
	  	}else if(!(na>='가'&&na<='힣'||na>='a'&&na<='z')){
	  		$('#na2').html('한글과 영문자만 사용해 주세요.')
	  	}else{
	  		$('#na2').html('입력 완료')
		  	}	
	  		return;
	  	}
	  //전화번호 제약조건
	  	function teltel() {
		  	var te = $('#tel1').val();
		  	if(te==''){
		  		$('#tel2').html('전화번호를 입력해주세요.')
		  	}else if(!(te>='0'&&te<='9')){
		  		$('#tel2').html('숫자만 입력해 주세요')
		  	}else{
		  		$('#tel2').html('입력 완료')
			  	}	
		  		return;
		  	}
		  //이메일 제약조건
	  	function emem() {
		  	var em = $('#email').val();
		  	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		  	if(!em.match(regExp)){
		  		$('#em2').html('Email 형식에 맞게 입력해주세요.')
		  	}else{
		  		$('#em2').html('입력이 완료되었습니다.')
		  	}
		  		return;
		} 
	//회원가입 취소 버튼
	function cancle() {
		location.href="main.do";
	}
		
</script>
</head>
<body>

	<form action="Uregist.do" method="POST">
		<table border="1" style="width: 650px; height: 700px">
			<tr>
				<th>아이디</th>
				<td><input type="hidden" id="idChk" value="N"> <input
					type="text" name="j_id" id="insertId" maxlength="30"> <input
					type="submit" value="중복체크" onclick="chkDupId()" class="btn btn-default">
					<h6 id="idid"></h6></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="j_pass" required="required"
					id="pass1" onkeyup="passchk()" maxlength="10"><br></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" required="required" id="pass2"
					onkeyup="passchk()" maxlength="10">
					<h6 id="passmessage"></h6></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="j_name" required="required"
					id="na1" onkeyup="nam()" maxlength="15">
					<h6 id="na2"></h6></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="button" onclick="sample6_execDaumPostcode()"
					value="우편번호 찾기" class="btn btn-default"> <input type="text" id="sample6_postcode"
					name="j_post" placeholder="우편번호"> <br> <input
					type="text" id="sample6_address" name="j_addr" placeholder="주소">
					<input type="text" id="sample6_address2" name="j_deaddr"
					placeholder="상세주소" maxlength="20"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="j_birth" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="j_tel" id="tel1"
					required="required" onkeyup="teltel()">
					<h6 id="tel2"></h6></td>
			</tr>
			<tr>
				<th>이메일주소</th>
				<td><input type="text" name="j_email" id="email"
					onkeyup="emem()"> <input type="button" id="auth_btn"
					value="인증하기" class="btn btn-default"><br>
					<h5 id="em2"></h5> 인증번호 : <input type="text" id="user_authNum"
					readonly="readonly">
					<div id="lab1"></div> <br></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="j_sex" value="female">여자
					<input type="radio" name="j_sex" value="male">남자</td>
			</tr>
			<tr>
				<th>직종</th>
				<td><select name="j_job">
						<option value="회사원">회사원</option>
						<option value="학생">학생</option>
						<option value="취업준비생">취업준비생</option>
						<option value="군인">회사원</option>
						<option value="주부">주부</option>
				</select></td>
			</tr>

		</table>
<%-- 	</form>
	<form action="Uregist.do" method="POST"> --%>

		<table style="margin-left: 365px;">

			<tr>
				<td><input type="submit" id="signUp_btn" value="가입완료"
					style="width: 150px; height: 30px;" class="btn btn-default"></td>
				<td><input type="button" value="취소" onclick="cancle()"
					style="width: 150px; height: 30px;" class="btn btn-default"></td>

			</tr>
		</table>
	</form>
</body>
</html>