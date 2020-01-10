<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url:"jobAjax.do",
				data:"keywords=api.saramin.co.kr/job-search?keywords=%EC%9B%B9%EA%B0%9C%EB%B0%9C%EC%9E%90&fields=posting-date+expiration-date&sort=ud&start=1&count=110",
				type:"POST",
				datatype:"json",
				success:function(doc){
					for (var i = 0; i < 110; i++) {
										
						var tr1=document.createElement("tr"); //<tr></tr>
						var inputtd1=document.createElement("input");
						var inputtd2=document.createElement("input");
						var inputtd10=document.createElement("input");
						var inputtd11=document.createElement("input");
						
						var tr2=document.createElement("tr");
						var td3=document.createElement("td");
						var td4=document.createElement("td");
						var td5=document.createElement("td");
						var td6=document.createElement("td");
						var td7=document.createElement("td");
						var td8=document.createElement("td");
// 						var td9=document.createElement("td");
						var input1=document.createElement("input");//location
						var input2=document.createElement("input");//jobtype
						var input3=document.createElement("input");//industry
						var input4=document.createElement("input");//jobcategory
						var input5=document.createElement("input");//exlevel
						var input6=document.createElement("input");//relevel
						var input7=document.createElement("input");//salary
						var input8=document.createElement("input");//ID
						var input9=document.createElement("input");//url
												
						$(inputtd1).val($(doc.p).find('name').eq(i).text()); //<td>값</td>
						$(inputtd2).val($(doc.p).find('title').eq(i).text());
						
						$(input1).val($(doc.p).find('location').eq(i).text());
						$(input2).val($(doc.p).find('job-type').eq(i).text());
						$(input3).val($(doc.p).find('industry').eq(i).text());
						$(input4).val($(doc.p).find('job-category').eq(i).text());
						$(input5).val($(doc.p).find('experience-level').eq(i).text());
												
						$(input6).val($(doc.p).find('required-education-level').eq(i).text());
						$(input7).val($(doc.p).find('salary').eq(i).text());
						$(input8).val($(doc.p).find('id').eq(i).text());
						$(input9).val($(doc.p).find('url').eq(i).text());
						
						doc1=$(doc.p).find('posting-date').eq(i).text();
						var a=doc1.substring(0, 10);
						$(inputtd10).val(a);
						doc2=$(doc.p).find('expiration-date').eq(i).text();
						var b=doc2.substring(0, 10);
						$(inputtd11).val(b);
						
						td4.appendChild(inputtd1).setAttribute("name", "co_name"); //<tr><td>값</td></tr>
						td5.appendChild(inputtd2).setAttribute("name", "co_title");
						td6.appendChild(inputtd10).setAttribute("name", "co_podate");
						td7.appendChild(inputtd11).setAttribute("name", "co_exdate");
						
						tr1.appendChild(td4).setAttribute('colspan','1');
						tr1.appendChild(td5).setAttribute('colspan','1');
						tr1.appendChild(td6).setAttribute('colspan','1');
						tr1.appendChild(td7).setAttribute('colspan','1');
						cop.appendChild(tr1);
						
						td3.appendChild(input1).setAttribute("name", "co_location");
						td3.appendChild(input2).setAttribute("name", "co_jobtype");
						td3.appendChild(input3).setAttribute("name", "co_industry");
						td3.appendChild(input4).setAttribute("name", "co_jobcategory");
						td3.appendChild(input5).setAttribute("name", "co_exlevel");
						td3.appendChild(input6).setAttribute("name", "co_relevel");
						td3.appendChild(input7).setAttribute("name", "co_salary");
						td3.appendChild(input8).setAttribute("name", "co_id");
						td3.appendChild(input9).setAttribute("name", "co_url");
						tr2.appendChild(td3).setAttribute('colspan','4');
						cop.appendChild(tr2);
					}
				}
			});
		});
	})
</script>
</head>
<body>
 	<form action="cominfo.do" method="POST">
		<table border="1" id="cop">
			<tr>
				<td>회사명</td>
				<td>공고명</td>
				<td>등록일</td>
				<td>채용마감일</td>
			</tr>
			
		</table>
		<input type="submit" value="정보전송"><!-- C_List -->
 	</form>
					<button id="saram1">채용정보확인</button>
</body>
</html>