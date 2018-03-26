
//makeTable(elem): //elem(jquery객체) -> ROW들[ROW,ROW,ROW...]
function makeTable(elem){ 
		var table=$("<table border='1'>");
		
		//컬럼정의하기 : <p> --> $("p").prop("tagName") = "p"
		// for tr1개, td 5개 --> <tr><td></td><td><td><td><td></tr>
		
		var tr=$("<tr>");
		for (var i = 0; i < elem.eq(0).children().length; i++) {
			var td=$("<td>").text(elem.eq(0).children().eq(i).prop("tagName"));
			tr.append(td);
		}
		table.append(tr);
		//-------------------------------------------------컬럼정의 끝
		
		//데이터를 넣기
		for (var i = 0; i < elem.length; i++) {
			var tr=$("<tr>");
			for (var j = 0; j < elem.eq(0).children().length; j++) {
				var td=$("<td>").append(elem.eq(i).children().eq(j).text());
				tr.append(td);
			}
			table.append(tr);
		}
		return table;
	}