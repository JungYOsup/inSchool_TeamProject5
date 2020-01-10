<%@page import="oracle.sql.DATE"%>
<%@page import="java.util.Date"%>
<%@page import="javax.swing.event.ListSelectionEvent"%>
<%@page import="com.min.inschool.daos.cominfo_daos"%>
<%@page import="com.min.inschool.dtos.cominfo_Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>



<!--------------------------------Calendar 링크 ----------------------------- -->
<link href='https://use.fontawesome.com/releases/v5.0.6/css/all.css'
	rel='stylesheet'>
<link href='resources/calendar/etc/fullcalendar.min.css'
	rel='stylesheet' />
<link href='resources/calendar/etc/fullcalendar.print.min.css'
	rel='stylesheet' media='print' />
<script src='resources/calendar/lib/moment.min.js'></script>
<script src='resources/calendar/lib/jquery.min.js'></script>
<script src='resources/calendar/etc/fullcalendar.min.js'></script>
<script src='resources/calendar/js/theme-chooser.js'></script>
<script src="resources/calendar/etc/locale-all.js"></script>
<meta charset='utf-8' />

<% List<cominfo_Dto> lists =  (List<cominfo_Dto>)request.getAttribute("comName"); %>

<script>
	


	 $(document).ready(function() {
		 
		 
		 var stat = $("input[name=start00]").val();
		 
		 
		    var initialLocaleCode = 'ko';
		    
		    var date = new Date();

			var YMD = date.toLocaleDateString();
		   
			var today = YMD.split(".")[0].trim()+"-"+YMD.split(".")[1].trim()+"-"+YMD.split(".")[2].trim();

		    $('#calendar').fullCalendar({
		    
		    	
		    	
		    	header: {
		        left: 'prev,next today',
		        center: 'title',
		        right: 'month,agendaWeek,agendaDay,listMonth'
		      },
		      
		      defaultDate: today,

		      locale: initialLocaleCode,
		      buttonIcons: true, // show the prev/next text
		      weekNumbers: true,
		      navLinks: true, // can click day/week names to navigate views
		      editable: true,
		      eventLimit: true, // allow "more" link when too many events
		      events: [
		    	  
	
		    	  
<%	

	
	for(int i =0; i<lists.size(); i++){
		
	
		
	%>

	
	  {
          title: '<%=lists.get(i).getCo_name()%>',
          start: '<%=lists.get(i).getCo_podate()%>',
          url:'<%=lists.get(i).getCo_url()%>'
	  }
	
	
	
	<%
	if(i<(lists.size()-1)){
		out.print(",");
		
		
	}
	
	
	}

%>
						        
		      ]
		    });

		  });

		</script>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 40px auto;
	padding: 0 10px;
}
</style>
</head>
<body>


	<div id='calendar'></div>


</body>
</html>
