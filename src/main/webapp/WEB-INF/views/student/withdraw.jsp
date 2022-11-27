<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<h2>회원탈퇴</h2>
<%
session.invalidate(); // 세션 초기화
%>
<form method="post" action="withdraw">
	<table class="list">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="studentNo" placeholder="학번을 입력하세요(9자리)"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" placeholder="비밀번호 입력"></td>
		</tr>
		<tr>
			<td><button type="submit">회원탈퇴</button></td>
		</tr>
	</table>
</form>


</body>
</html>