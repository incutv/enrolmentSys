<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/common.css"/>

<style>
a.btn { float: right; margin: -20px 0 5px 0; }
td:nth-child(1) { text-align: center; }
ul {
	list-style: none;
	width : 30%;
	display: inline-block;
}

li {
	float: left;
	margin-left : 5px;
}
</style>
<title>수강신청</title>
<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script type="text/javascript">
$(function(){
	 $("input:checkbox[name=lectureId]").click(function() {  
		var customerNumber = $(this).val();  
		var i = $('input:checkbox[name=lectureId]').index(this); 
		var credit = 'credit' + i;
		
		$('#credit').val($('#'+credit).val());
		
		$("input:checked[name=lectureId]").each(function() {    
			if (customerNumber != $(this).val()) {     
				$(this).attr("checked", false);
			}
	  	});
	});
}); 
</script>
</head>
<body>
<%
	Integer studentId = (Integer)session.getAttribute("id");
%>
<!-- top.jsp를 include -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<h1>수강신청하기 </h1>
<form method="post" action="list">
	<table class="list">
	<tr> <th>강좌코드</th>
	<th width="50%">교과목명</th>
	<th>교수</th>
	<th>학점</th>
	<th>강의실</th>
	<th>빈자리</th>
	<th>선택</th>
	</tr>
	<tr>
	<tbody>
	<c:forEach var="lecture" varStatus="status" items="${ lectures }">
	<tr>
	<td><input type="hidden" name="lectureId${status.index }" value=${ lecture.id }>${ lecture.id } </td>
	<td>${ lecture.title }</td>
	<td>${ lecture.professor.name }</td>
	<td><input type="hidden" id="credit${ status.index }" value=${ lecture.credit }>${ lecture.credit }</td>
	<td>${ lecture.room }</td>
	<td>${ lecture.seatCnt }</td>
	<!--<td><input type="submit" value="수강신청" id="lectureBtn${status.index }" onclick="goSugang(this.form)"/></td>  -->	
	<td><input type="checkbox" value=${ lecture.id } id="lectureId" name="lectureId"></td> 
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<br><br>
	<input type="hidden" name="studentId" value=${ studentId}>
	<input type="hidden" name="year" value="2022">
	<input type="hidden" name="semester" value="2">
	<input type="hidden" id="credit" name = "credit" value="">
	<input type="submit" value="수강신청" style="float: left;">
<!-- <input type="button" value="수강신청" style="float: left;" onclick="goSugang(this.form)"/> -->	
</form>
</body>
</html>
