<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이메일 인증</title>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> -->

<!-- 이메일인증 api -->
<script src="https://smtpjs.com/smtp.js"></script>
<script type="text/javascript">
    $(function () {
        $("#auth_btn").click(function () {
            var data = {"email": $("#email").val()};
            var authNum = "";
			//입력한 이메일 값을 불러옴 돔탐색
            var emailsin = document.getElementById('email').value;
            $.ajax({
                url : "emailAuth.do",
                data : data,
                type : "POST",
                success : function (data) {
                    authNum = data;
					//이메일을 보내는 소스        
                    Email.send("yoyoyosup@naver.com",
                    		emailsin,
                    		"면접커뮤니티 가입인증 확인 메일 입니다.",
                    		"인증번호를 확인 후 인증 화면에 입력해 주세요."+""+"인증번호"+" : "+authNum,
                    		"smtp.naver.com",
                    		"yoyoyosup","wjddytjq1004@");
					
                    chk = checkNum(authNum);
                    
                    if(chk > 0){
                        alert("인증완료");
                        $("#lab1").html("<label>인증완료</label>");
                    }
                    else{
                        alert("인증실패");
                        $("#lab1").html("<label>인증실패</label>");
                    }
                }
                
            });
            
        });// 이메일 인증 버튼 end

        // 회원가입
        $("#signUp_btn").click(function () {
            if( chk > 0  ){
                return true;
            }else{
                alert("이메일 인증을 완료하여 주세요.");
                return false;
            }
        });
    });

</script>

<script type="text/javascript">
    function checkNum(authNum) {

    	var chk = 0;
        var user_authNum = prompt("인증번호를 입력하세요.");
        
        // 인증번호 비교
        if (authNum == user_authNum) {
            chk = 1;
            $("#user_authNum").val(user_authNum);
        } else {
            chk = -1;
        }
        return chk;
    };
</script>
<!-- 다음 주소 검색 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
</head>
<body>
</body>
</html>