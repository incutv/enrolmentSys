<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="application/json; charset=UTF-8"/>
<title>글쓰기</title>

<script>
function goWrite(frm) {
	var subject = frm.subject.value;
	var contents = frm.contents.value;
	
	if (subject.trim() == ''){
		alert("제목을 입력해주세요");
		return false;
	}
	
	if (contents.trim() == ''){
		alert("내용을 입력해주세요");
		return false;
	}
	frm.submit();
} 
</script>	
</head>
<body>
<h2 style="text-align: center;">글 작성</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="write">
		<input type="text" name="writer" style="width: 20%;" placeholder="작성자"/><br>
		<input type="text" name="subject" style="width: 40%;" placeholder="제목"/>
		<input type="date" name="start_date" style="width: 40%;" placeholder="시작일자"/>
		<input type="date" name="end_date" style="width: 40%;" placeholder="종료일자"/>
		<br><br> 
		<textarea id="contents" name="contents"></textarea>
		<input id="subBtn" type="button" value="글 작성" style="float: right;" onclick="goWrite(this.form)"/>
	</form>
</div>

</body>
</html>