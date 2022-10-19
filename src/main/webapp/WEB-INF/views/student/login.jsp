<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<h2>로그인</h2>
<form method="post" action="login">
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
			<td><button type="submit">로그인</button></td>
			<td><button type="button" onclick="location.href= 'signup'">회원가입</button>
		</tr>
	</table>
</form>
</body>
</html>