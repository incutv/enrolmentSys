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
<th>신청</th>
<th>교과목명</th>
<th>교수</th>
<th>학점</th>
<th>강의실</th>
</tr>
</thead>
<tbody>
<c:forEach var="sugang" items="${ sugangs }">
<tr>
<td><a href="studentList?id=${ sugang.id }">신청</a></td>
<td>${ sugang.title }</td>
<td>${ sugang.professorName }</td>
<td>학점</td>
<td>${ sugang.room }</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>