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
<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script type="text/javascript">
$(function(){
	 $("input:checkbox[name=lectureId]").click(function() {  
		var customerNumber = $(this).val();  

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
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<div class="container">
<h1>수강신청내역</h1>
<form method="post" action="studentList">
	<table class="list">
	<thead>
	<tr>
	<th>교과목명</th>
	<th>교수</th>
	<th>학점</th>
	<th>강의실</th>
	<th>빈자리</th>
	<th>선택</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="student" items="${ students }">
	<tr>
		<td>${ student.title }</td>
		<td>${ student.name }</td>
		<td>${ student.credit }</td>
		<td>${ student.room }</td>
		<td>${ student.seatCnt }</td>
		<td><input type="checkbox" value=${ student.lectureId } id="lectureId" name="lectureId"></td>
		<td><input type="hidden" name="id" id ="id" value=${ student.id } ></td>
	</tr>
		<!-- <c:forEach var="lecture" items="${ student.lecture }"> !-->
		<%-- 	<tr>
			<td>${ lecture.title }</td>
			<td>${ lecture.name }</td>
			<td>${ lecture.credit }</td>
			<td>${ lecture.room }</td>
			<td>${ lecture.seatCnt }</td>
			</tr>  --%>
		<!-- </c:forEach> !-->
	</c:forEach>
	</tbody>
	</table>
	<br><br>
	<input type="submit" value="수강취소" style="float: left;">
	</form>
</div>
</body>
</html>