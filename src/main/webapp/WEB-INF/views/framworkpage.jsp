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

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Justified Nav Template for Bootstrap</title>

<style type="text/css">

.drop-menu{

	position: absolute;
}

.drop-menu li{
	background-color: red;
	width: 159px;
	
	
	list-style-type: none;
	
	margin: 1px;
}

ul,li{

	padding: 0px;
	margin: 0px;
	
}


</style>


<script type="text/javascript">

	  $(function () {
		  
		  
		  $(".drop-menu").hide();
		  
		  
		  $(".title").click(function() {
			  
			  $(this).next("ul").slideToggle();
			  
			  $(this).parent().siblings("li").find("ul").hide();
		  	
			  
		  });
		  
		  
		
		 });
	  
	  
	   



</script>
</head>
<body>

	<div class="container">

		<div class="masthead">
			<h3 class="text-muted">Project name</h3>
			<nav>
			<ul class="nav nav-justified">
				<li class="active">
				<a href="#" class="title">소개</a>
				<ul class="drop-menu">
					<li><a href="#">A</a></li>
					<li><a href="#">A</a></li>
					<li><a href="#">A</a></li>
					<li><a href="#">A</a></li>
					<li><a href="#">A</a></li>
					<li><a href="#">A</a></li>
				</ul>
				</li>
				
				<li>
				<a href="#" class="title">동영상</a>
				<ul  class="drop-menu">
					<li>A</li>
					<li>B</li>
					<li>C</li>
					<li>B</li>
					<li>B</li>
					<li>B</li>
				</ul>
								
				
				</li>
				<li><a href="#" class="title">면접게시판</a>
				<ul  class="drop-menu">
					<li>A</li>
					<li>B</li>
					<li>C</li>
					<li>B</li>
					<li>B</li>
					<li>B</li>
				</ul>
								
				
				</li>
				<li><a href="#" class="title">이력서게시판</a>
				<ul  class="drop-menu">
					<li>A</li>
					<li>B</li>
					<li>C</li>
					<li>B</li>
					<li>B</li>
					<li>B</li>
				</ul>
								
				
				</li>
				<li><a href="#" class="title">학습게시판</a>
				<ul  class="drop-menu">
					<li>A</li>
					<li>B</li>
					<li>C</li>
					<li>B</li>
					<li>B</li>
					<li>B</li>
				</ul>
								
				
				</li>
				
				<li><a href="#" class="title">자유게시판</a>
				<ul  class="drop-menu">
					<li>A</li>
					<li>B</li>
					<li>C</li>
					<li>B</li>
					<li>B</li>
					<li>B</li>
				</ul>
								
				
				</li>
				
				<li><a href="#" class="title">Q&A</a>
				<ul  class="drop-menu">
					<li>A</li>
					<li>B</li>
					<li>C</li>
					<li>B</li>
					<li>B</li>
					<li>B</li>
				</ul>
								
				
				</li>
				
			</ul>
			</nav>
		</div>

		<!-- 광고가 들어가는 곳 -->
		<div class="jumbotron">
		
		
			
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
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
			<div class="col-lg-4">
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
			<div class="col-lg-4">
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

		<!-- Site footer -->
		<footer class="footer">
		<p>© Company 2014</p>
		</footer>

	</div>
	<!-- /container -->




</body>
</html>