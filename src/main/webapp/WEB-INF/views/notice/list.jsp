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
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<div class="container">
<h1>공지사항</h1>
<a href="write" class="btn">글쓰기</a>
<table class="list">
<thead>
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>작성일</th>
<th>조회</th>
</tr>
</thead>
<tbody>
<c:forEach var="notice" items="${ notices }">
<tr>
<td>${ notice.seq }</td>
<td><a href="view?seq=${ notice.seq }">${ notice.subject }</a></td>
<td>${ notice.writer }</td>
<td><fmt:formatDate pattern="yyyy-MM-dd" value="${ notice.req_date }"/></td>
<td>${ notice.views }</td>
</tr>
</c:forEach>
</tbody>
</table>
  <ul class="pagination">
	<c:if test="${pageMaker.prev }">
		<li class="pagination_button">
			<a href="list?pageNum=${pageMaker.startPage - 1 }">Previous</a>
		</li>
	</c:if>
	
	<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
		<li class="pagination_button">
			<a href="list?pageNum=${num}&amount=${reqCriteria.amount}">${num}</a>
		</li>
	</c:forEach>
	
	<c:if test="${pageMaker.next }">
		<li class="pagination_button">
			<a href="list?pageNum=${pageMaker.endPage + 1 }">Next</a>
		</li>
	</c:if>
</ul>
</div>
</body>
</html>