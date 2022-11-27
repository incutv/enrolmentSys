<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="application/json; charset=UTF-8"/>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
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

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	  
	  document.getElementById("start_date").value = new Date().toISOString().slice(0,10);
	  document.getElementById("end_date").value = new Date().toISOString().slice(0,10);
	});
</script>
</head>
<body>
<h2 style="text-align: center;">글 작성</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="write">
		<input type="text" name="writer" style="width: 20%;" placeholder="작성자"/><br>
		<input type="text" name="subject" style="width: 40%;" placeholder="제목"/>
		<input type="date" id = "start_date" name="start_date" style="width: 40%;" placeholder="시작일자" />
		<input type="date" id = "end_date" name="end_date" style="width: 40%;" placeholder="종료일자"/>
		<br><br> 
		<textarea id="summernote" name="contents"></textarea>
		<input id="subBtn" type="button" value="글 작성" style="float: right;" onclick="goWrite(this.form)"/>
	</form>
</div>

</body>
</html>