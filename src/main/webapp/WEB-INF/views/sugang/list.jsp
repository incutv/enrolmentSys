<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강신청</title>
</head>
<body>
<h1>수강신청하기</h1>
<table border="1">
<tr> <th>강좌코드</th>
<th width="50%">교과목명</th>
<th>교수</th>
<th>학점</th>
<th>강의실</th>
<th>선택</th>
</tr>
<tr>
<tbody>
<c:forEach var="lecture" items="${ lectures }">
<tr>
<td>${ lecture.id }</td>
<td>${ lecture.title }</td>
<td>${ lecture.professor.name }</td>
<td>${ lecture.credit }</td>
<td>${ lecture.room }</td>
<td><input type="checkbox" value=${ lecture.id } id="item_list" name="item_list"></td>
</tr>
</c:forEach>
</tbody>
</table>
<p align="right"><input type="submit" value="수강신청"></p>
</body>
</html>