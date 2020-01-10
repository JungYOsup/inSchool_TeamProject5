<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 창</title>
<!-- <style type="text/css">
	#passmessage{
		display: inline-block;
	}
</style> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

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
	function nam1() {
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
	function nam2() {
	  	var na = $('#na3').val();
	  	if(na==''){
	  		$('#na4').html('이름을 입력해주세요.')
	  	}else if(!(na>='가'&&na<='힣'||na>='a'&&na<='z')){
	  		$('#na4').html('한글과 영문자만 사용해 주세요.')
	  	}else{
	  		$('#na4').html('입력 완료')
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
	
  	
	<form action="Cregist.do" method="POST">
		<table border="1" style="width: 650px; height: 700px">
			<tr>
				<th>아이디</th>
				<td>
					<input type="hidden" id="idChk" value="N">
					<input type="text" name="j_id" id="insertId" maxlength="10">
					<input type="submit" value="중복체크" onclick="chkDupId()" class="btn btn-default">
					<h5 id="idid"></h5>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="j_pass" required="required" id="pass1" onkeyup="passchk()" maxlength="10"><br>
				</td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td>
					<input type="password" required="required" id="pass2" onkeyup="passchk()" maxlength="10">
					<h5 id="passmessage"></h5>
				</td>		
			</tr>
			
			<tr>
				<th>회사명</th>
				<td><input type="text" name="j_name" required="required"></td>			
			</tr>
			<tr>
				<th>회사주소</th>
				<td>
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="btn btn-default">
					<input type="text" id="sample6_postcode" name="j_post" placeholder="우편번호">
					<br><input type="text" id="sample6_address" name="j_addr" placeholder="주소">
					<input type="text" id="sample6_address2" name="j_deaddr" placeholder="상세주소" maxlength="20">
				</td>			
			</tr>
			<tr>
				<th>회사전화번호</th>
				<td>
					<input type="tel" name="j_tel" id="tel1" required="required" onkeyup="teltel()">
					<h5 id="tel2"></h5>
				</td>			
			</tr>
			<tr>
				<th>회사이메일</th>
				<td>
					<input type="text" name="j_email" id="email" onkeyup="emem()">
					<input type="button" id="auth_btn" value="인증하기" class="btn btn-default"><br>
					<h5 id="em2"></h5>
					인증번호 : <input type="text" id="user_authNum" readonly="readonly"><div id="lab1"></div><br>
				</td>
			</tr>
			<tr>
				<th>기업형태</th>
				<td>
					<select name="j_comtype" required="required">
						<option value="자영업">자영업</option>
						<option value="벤쳐기업">벤쳐기업</option>
						<option value="중소기업">중소기업</option>
						<option value="중견기업">중견기업</option>
						<option value="외국계">외국계</option>
						<option value="대기업">대기업</option>
						<option value="기타">기타</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>사업자등록번호</th>
				<td><input type="text" name="j_comnumsal" required="required">
			</tr>
			<tr>
				<th>대표자명</th>
				<td>
					<input type="text" name="j_comboss" required="required" id="na3" onkeyup="nam()" maxlength="15">
					<h5 id="na4"></h5>
				</td>
			</tr>
			
		</table>
	</form>
	<form action="Cregist.do" method="POST">

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