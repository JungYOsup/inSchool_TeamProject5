<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/daumOpenEditor/editor_frame.jsp"></jsp:include>
	<script type="text/javascript">
		// '수정하기' 모드일 때, 다음과 같이 데이터를 다음오픈에디터에 대입할 수 있다.
		if ('${board!=null}' == 'true')
			Editor.modify({
				'content' : '${board.board_content}'
			});
	</script>
	<script type="text/javascript">
		var config = {
			txHost : '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) http://xxx.xxx.com */
			txPath : '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) /xxx/xxx/ */
			txService : 'sample', /* 수정필요없음. */
			txProject : 'sample', /* 수정필요없음. 프로젝트가 여러개일 경우만 수정한다. */
			initializedId : "", /* 대부분의 경우에 빈문자열 */
			wrapper : "tx_trex_container", /* 에디터를 둘러싸고 있는 레이어 이름(에디터 컨테이너) */
			form : 'tx_editor_form' + "", /* 등록하기 위한 Form 이름 */
			txIconPath : "${ pageContext.request.contextPath }/resources/daumOpenEditor/images/icon/editor/", /* 에디터에 사용되는 이미지 디렉터리, 필요에 따라 수정한다. */
			txDecoPath : "${ pageContext.request.contextPath }/resources/daumOpenEditor/images/deco/contents/", /* 본문에 사용되는 이미지 디렉터리, 서비스에서 사용할 때는 완성된 컨텐츠로 배포되기 위해 절대경로로 수정한다. */
			canvas : {
				exitEditor : { /* desc:'빠져 나오시려면 shift+b를 누르세요.', hotKey: { shiftKey:true, keyCode:66 }, nextElement: document.getElementsByTagName('button')[0] */},
				styles : {
					color : "#123456", /* 기본 글자색 */
					fontFamily : "굴림", /* 기본 글자체 */
					fontSize : "10pt", /* 기본 글자크기 */
					backgroundColor : "#fff", /*기본 배경색 */
					lineHeight : "1.5", /*기본 줄간격 */
					padding : "8px" /* 위지윅 영역의 여백 */
				},
				showGuideArea : false
			},
			events : {
				preventUnload : false
			},
			sidebar : {
				attachbox : {
					show : true,
					confirmForDeleteAll : true
				},
				attacher : {
					image : {
						features : {
							left : 250,
							top : 65,
							width : 400,
							height : 190,
							scrollbars : 0
						}, //팝업창 사이즈 
						
						popPageUrl : 'imagePopup.do' //팝업창 주소 
					},
					file:{ features:{left:250,top:65,width:400,height:190,scrollbars:0}, // 팝업창 사이즈
						popPageUrl:'filePopup.do' // 팝업창 주소 
						} 

				},
				capacity : {
					maximum : 500 * 1024 * 1024
				//최대 첨부용량
				}

			},
			size : {
				contentWidth : 700
			/* 지정된 본문영역의 넓이가 있을 경우에 설정 */}
		};
		EditorJSLoader.ready(function(Editor) {
			var editor = new Editor(config);
		});

		// submit 전 다음에디터 validation체크
		function validForm(editor) {
			var validator = new Trex.Validator();
			var content = editor.getContent();
			if (!validator.exists(content)) {
				alert('내용을 입력하세요');
				return false;
			}
			return true;
		}

		//validForm 함수가 true로 return된 후에 동작하는 함수 
		function setForm(editor) {

			var content = editor.getContent(); // 본문 내용을 필드를 생성하여 값을 할당하는 부분
			//content 내용을 받은것을 textarea 에 value값에다가 전달해주고 그것의 name을 통해서 submit
			//content 내용 받은것을 어떻게 textarea 전달할 것인가 그리고 그 textarea는 안보이게끔 하고.
			alert(content); //<p>123123</p>

			/*content내용이 4000자 이상일 경우 잘라서 다른 데이터베이스에 넣는 유효처리를 해줘야함  */
			
			var a = document.getElementsByClassName("textcontent")[0].innerHTML = content; //textarea는 value로 값을 집어 넣는다 
					
			
			return true;
				
		}

		function saveContent() {
			Editor.save();
		}
	</script>



</body>
</html>









