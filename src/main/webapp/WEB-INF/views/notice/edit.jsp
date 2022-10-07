<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="application/json; charset=UTF-8"/>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  -->
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
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	  // Summernote에 글 내용 추가하는 코드
	  $("#summernote").summernote('code',  '${notice.contents}');
	});
</script>
</head>
<body>
<h2 style="text-align: center;">글 수정</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="edit"  enctype="application/x-www-form-urlencoded">
		<input type="hidden" name="seq" value="${notice.seq}">
		<input type="hidden" name="update_date" value="${notice.update_date }">
		<input type="text" name="writer" style="width: 20%;" placeholder="작성자" value="${notice.writer }" readonly/><br>
		<input type="text" name="subject" style="width: 40%;" placeholder="제목" value="${notice.subject }">
		<input type="date" name="start_date" style="width: 40%;" placeholder="시작일자" value="${notice.start_date }">
		<input type="date" name="end_date" style="width: 40%;" placeholder="종료일자" value="${notice.end_date }">		
		<br><br> 
		<textarea id="summernote" name="contents"></textarea>
		<input id="subBtn" type="button" value="글 수정" style="float: right;" onclick="goModify(this.form)"/>
		<!-- <input type="hidden" name="_method" value="post"/> -->
	</form>
</div>
<script>
function goModify(frm) {
	var subject = frm.subject.value;
	var writer = frm.writer.value;
	var contents = frm.contents.value;

	
	if (subject.trim() == ''){
		alert("제목을 입력해주세요");
		return false;
	}
	if (writer.trim() == ''){
		alert("작성자를 입력해주세요");
		return false;
	}
	if (contents.trim() == ''){
		alert("내용을 입력해주세요");
		return false;
	}
	frm.submit();
}
</script>
</body>
</html>