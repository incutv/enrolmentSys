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
</head>
<body>
<div class="container">
<h1>수강신청내역</h1>
<table class="list">
<thead>
<tr>
<th>교과목명</th>
<th>교수</th>
<th>학점</th>
<th>강의실</th>
<th>빈자리</th>
</tr>
</thead>
<tbody>
<c:forEach var="student" items="${ students }">
	<c:forEach var="lecture" items="${ student.lecture }">
		<tr>
		<td>${ lecture.title }</td>
		<td>${ lecture.name }</td>
		<td>${ lecture.credit }</td>
		<td>${ lecture.room }</td>
		<td>${ lecture.seatCnt }</td>
		</tr>
	</c:forEach>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>