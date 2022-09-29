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
			<td>
				시작일자: <fmt:formatDate value="${notice.start_date}" pattern="yyyy.MM.dd"/> </td>
		</tr>
		<tr>
			<td>
				종료일자: <fmt:formatDate value="${notice.end_date}" pattern="yyyy.MM.dd"/> </td>
		</tr>
		<tr>
			<td><div style="height: 300px; margin: 10px; display: inline-block">${notice.contents }</div></td>
		</tr>
	</table>
	<input type="button" value="목록" style="float: right;" onclick="location.href='list';">
	<input type="button" value="수정" style="float: right;" onclick="location.href='edit?seq=${notice.seq}';">
	<input type="button" value="삭제" style="float: right;" onclick="if (confirm('정말로 삭제하시겠습니까?')) location.href='delete?seq=${notice.seq}';">
	<!--<a href="delete?seq=${ notice.seq }"role="button" class="btn btn-outline-info">삭제</a>  
	<input type="button" value="삭제" style="float: right;" onclick="location.href='delete/${notice.seq}';"> 
	<form id="delete_form" action="delete" method="post">
    <input type="hidden" name="_method" value="delete">
    <a onclick="if (confirm('정말로 삭제하시겠습니까?')) submit();" class="btn btn-danger">삭제</a> 
	</form> !-->
	<br>
		<c:forEach var="replyList" items="${ replyList }">
		<table border="1">
			<tr>
				<!-- 아이디, 작성일자 -->
				<td width="150">
					<div>
						${replyList.reply_writer }<br>
						<font size="2" color="lightgray"><fmt:formatDate value="${replyList.reply_date}" pattern="yyyy-MM-dd" /> </font>
					</div>
				</td>
				<!-- 본문내용 -->
				<td width="550">
					<div class="text_wrapper">
						${replyList.reply_content }
					</div>
				</td>
				<!-- 버튼 -->
				<td width="100">
					<div id="btn" style="text-align:center;">
						<a href="#">[답변]</a><br>
					<!-- 댓글작성자만 수정, 삭제 -->
					<!-- <c:if test="${replyList.reply_writer == sessionScope.sessionID }"> !-->
						<a href="#">[수정]</a><br>
						<a href="#">[삭제]</a>
					<!-- </c:if> !-->
					</div>
				</td>
			</tr>
		</table>
		</c:forEach>
	<!-- 댓글  <c:if test="${sessionScope.sessionID != null }"> -->
		<table border="1">
		<tr bgcolor="#F5F5F5">
		<form id="replyForm">
			<input type="hidden" name="reply_seq" value="${replyList.reply_seq }">
			<input type="hidden" name="reply_writer" value = "${replyList.reply_writer }">
		</form>
			<!-- 아이디 -->
			<td width="150">
				<div>
					${sessionScope.sessionID }
				</div>
			</td>
			<!-- 본문 -->
			<td width="550">
				<div>
					<textarea name="reply_content" rows="4" cols="70"></textarea>
				</div>
			</td>
			<!-- 댓글등록 -->
			<td width="100">
				<div id="btn" style="text-align:center;">
					<p><a href="#" onclick="writeReply()">[댓글등록]</a></p>
				</div>
			</td>
		</tr>
		
		</table>
		
	<!-- </c:if> !-->
</div>
</body>
</html>