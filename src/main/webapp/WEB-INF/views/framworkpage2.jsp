<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/modernizr.custom.js"></script>
<link href="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/css/style.css" rel="stylesheet">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<style type="text/css">


img{

	height: 175px;
	width: 175px;


}


</style>

<script type="text/javascript">

	function popupOpen(){

	 var popUrl = "chat.do";	//팝업창에 출력될 페이지 URL

	 var popOption = "width=370, height=500, resizable=no, scrollbars=no, status=no;";     //팝업창 옵션(optoin)

		window.open(popUrl,"",popOption);

	}



</script>


<title>Justified Nav Template for Bootstrap</title>

</head>
<body>

	<div class="container">
		
		<jsp:include page="header.jsp"></jsp:include>
		
		

		<!-- 광고가 들어가는 곳 -->
		<div class="jumbotron">
		
		
			
		</div>

		<!-- 최신화 데이터를 보여주는 곳.-->
		<div class="row">
			<div class="col-lg-5">
				<h2>Safari bug warning!</h2>
				<p class="text-danger">As of v8.0, Safari exhibits a bug in
					which resizing your browser horizontally causes rendering errors in
					the justified nav that are cleared upon refreshing.</p>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-primary" href="#" role="button">View details
						»</a>
				</p>
			</div>
			<div class="col-lg-5">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-primary" href="#" role="button">View details
						»</a>
				</p>
			</div>
			<div class="col-lg-2">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa.</p>
				<p>
					<a class="btn btn-primary" href="#" role="button">View details
						»</a>
				</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-5">
				<h2>Safari bug warning!</h2>
				<p class="text-danger">As of v8.0, Safari exhibits a bug in
					which resizing your browser horizontally causes rendering errors in
					the justified nav that are cleared upon refreshing.</p>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-primary" href="#" role="button">View details
						»</a>
				</p>
			</div>
			<div class="col-lg-5">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce
					dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
					ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
					magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-primary" href="#" role="button">View details
						»</a>
				</p>
			</div>
			<div class="col-lg-2">
				<img onclick="popupOpen()" src="${ pageContext.request.contextPath }/resources/img/Messages.png">
			</div>
		</div>
		
		

		<!-- Site footer -->
		<footer class="footer">
		<p>© Company 2014</p>
		</footer>
		
		<script src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/jquery.min.js"></script>
		<script src="${ pageContext.request.contextPath }/resources/MultiDropdownMenu/js/dropdownmenu.min.js"></script>
		
		<script>
		
		dropdownmenu.init();
		
		</script>

	</div>
	<!-- /container -->




</body>
</html>