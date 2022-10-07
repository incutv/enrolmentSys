<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강신청</title>
<!--  <script>
function goSugang(frm) {
	var valueArr = new Array();
	var list = $("input[name='lectureId']");
	for(var i =0; i< list.length; i++){
		if(list[i].checked){
			valueArr.push(list[i].value);
		}
	}
	
	if(valueArr.length==0){
		alert("선택된 과목이 없습니다.");
	} else{
		$.ajax({
			data : {
				valueArr : valueArr
			}
		})
	}
	
	
	frm.submit();
} 	
</script>
-->

</head>
<body>
<h1>수강신청하기 </h1>
<form method="post" action="list">
	<table border="1">
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
	<c:forEach var="lecture" items="${ lectures }">
	<tr>
	<td><input type="hidden" name="lectureId" value=${ lecture.id }>${ lecture.id } </td>
	<td>${ lecture.title }</td>
	<td>${ lecture.professor.name }</td>
	<td><input type="hidden" name="credit" value=${ lecture.credit }>${ lecture.credit }</td>
	<td>${ lecture.room }</td>
	<td>${ lecture.seatCnt }</td>
	<td><input type="checkbox" value=${ lecture.id } id="lectureId" name="lectureId"></td> 
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<br><br>
	<input type="hidden" name="studentId" value="1">
	<input type="hidden" name="year" value="2022">
	<input type="hidden" name="semester" value="2">
	<input type="submit" value="수강신청" style="float: left;">
<!-- <input type="button" value="수강신청" style="float: left;" onclick="goSugang(this.form)"/> -->	
</form>
</body>
</html>
