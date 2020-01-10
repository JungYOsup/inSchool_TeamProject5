<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
<title>Insert title here</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">
#label {
	color: red;
}
;
</style>
<script type="text/javascript">

	function regist() {
		location.href = "registmain.do";
	}
	function myinfo() {
		location.href = "myinfo.do";
	}
	function myinfo2() {
		location.href = "comjob.do";
	}

	//<![CDATA[
	// 사용할 앱의 JavaScript 키를 설정해 주세요.
	// api  앱키 
	Kakao.init('e904b47435b9a3bfa57fedf66e8f061f');

	function loginWithKakao() {
		// 로그인 창을 띄웁니다. 카카오 로그인 버튼을 생성 
		Kakao.Auth.login({
			//	container: '#kakao-login-bin', 
			success : function(authObj) { // ↓ 토큰오는지 확인 하는 것
				//alert(JSON.stringify(authObj));
				/* alert(authObj); 요건 object*/
				//alert(Kakao.Auth.getAccessToken());
				//  로그인이 성공하면  API 를호출한다
				Kakao.API.request({
					url : "/v1/user/me",
					success : function(result) {
						var sData = JSON.stringify(result);
						/* alert(JSON.stringify(authObj));
						alert(sData); */

						sData = JSON.parse(sData);
						var email = sData.kaccount_email;
						/* alert(email); */
						var route = "kakao";
						var id = sData.id + "@" + route;
						var nickname = sData.properties.nickname;
						/* alert(nickname); */
						var thumbnail_image = sData.properties.thumbnail_image;
						var profile_image = sData.properties.profile_image;
						var accessToken = Kakao.Auth.getAccessToken();
						/* alert(accessToken); */
						var refreshToken = Kakao.Auth.getRefreshToken();
						var f = document.createElement("form");
						f.setAttribute("method", "post");
						f.setAttribute("style", "display:none");
						f.setAttribute("action", "kakaoLogin.do");
						f.setAttribute("target", "_self");
						var i_id = document.createElement("input");
						i_id.setAttribute("type", "hidden");
						i_id.setAttribute("name", "j_id");
						i_id.setAttribute("value", id);
						var i_email = document.createElement("input");
						i_email.setAttribute("type", "hidden");
						i_email.setAttribute("name", "j_id");
						i_email.setAttribute("value", email);
						f.appendChild(i_email);
						var i_nick = document.createElement("input");
						i_nick.setAttribute("type", "hidden");
						i_nick.setAttribute("name", "j_name");
						i_nick.setAttribute("value", nickname);
						f.appendChild(i_nick);
						var i_accessToken = document.createElement("input");
						i_accessToken.setAttribute("type", "hidden");
						i_accessToken.setAttribute("name", "k_accessToken");
						i_accessToken.setAttribute("value", accessToken);
						var submitB = document.createElement("input");
						submitB.setAttribute("type", "submit");
						submitB.setAttribute("value", "subB");
						f.appendChild(submitB);

						$("#custom-login-btn").append(f);

						f.submit();

					}
				})
			},
			fail : function(err) {
				alert(JSON.stringify(err) + "안녕나야");//실패시 
			}
		});

	};
</script>
</head>
<body>
	<!--로그인창  -->
	<form action="LoginProcess.do" method="post">

		<table>
			<tr>
				<td><input type="text" name="j_id" id="id1" placeholder="아이디"></td>

				<td rowspan="2"><input type="submit" value="로그인" id="sub"
					style="height: 55px"></td>
			</tr>
			<tr>
				<td><input type="password" name="j_password" id="pw"
					placeholder="비밀번호"></td>
			</tr>
			
			<c:choose>
			
			<c:when test="${not empty errorMessage }">
			
			<tr>
				<td colspan="2">
					<div>
						<label id="label">${errorMessage}</label>
					</div>
				</td>
			</tr>
			
			</c:when>
			
			
			
			
			
			</c:choose>
		</table>


	</form>

	<!--카카오  -->
	<a id="custom-login-btn" href="javascript:loginWithKakao()"> <img
		src="images/kakao.png" width="500px" /> <!--회원가입  -->


	</a>
	
	<a onclick="regist()">회원가입</a>
</body>
</html>