<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 상세보기</title>
</head>
<style>
	h2 { text-align: center;}
  table { width: 100%;}
  textarea { width: 100%;}
 	#outter {
		display: block;
		width: 30%;
		margin: auto;
	}
</style>
<body>

<h2>공지사항</h2>
<br><br><br>
<div id="outter">
	<table border="1">
		<tr>
			<td>제목: ${notice.subject }</td>
		</tr>
		<tr>
			<td>
				작성자: ${notice.writer }
				<span style="float: right;"><fmt:formatDate value="${notice.date }" pattern="yyyy.MM.dd"/></span>
			</td>
		</tr>
		<tr>
			<td><div style="height: 300px; margin: 10px; display: inline-block">${notice.contents }</div></td>
		</tr>
	</table>
	<input type="button" value="목록" style="float: right;" onclick="location.href='list';">
	<input type="button" value="수정" style="float: right;" onclick="location.href='edit?seq=${notice.seq}';">
	<form id="delete_form" action="delete" method="post">
    <input type="hidden" name="_method" value="delete" onclick="location.href='delete?seq=${notice.seq}';">
    <a onclick="if (confirm('정말로 삭제하시겠습니까?')) document.getElementById('delete_form').submit();" class="btn btn-danger">삭제</a>
	</form>
</div>
</body>
</html>