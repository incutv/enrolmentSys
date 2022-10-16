<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>회원가입</title>
<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script type="text/javascript">
function checkValue() {

	if(!document.signup.studentNo.value){
		alert("학번을 입력하세요.");
		return false;
	}

	if(document.signup.studentNo.value.length != 9 ){
		alert("학번은 9자리로 입력해주세요");
		return false;
	}
	
	if(!document.signup.password.value){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if(!document.signup.password.value != !document.signup.password2.value ){
		alert("비밀번호를 다시한번 확인해주세요.");
		return false;
	}
	
	if(!document.signup.password.value ){
		alert("이름을 입력하세요.");
		return false;
	}
	
}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<h2>회원가입</h2>
<form method="post" action="signup" name = "signup" onsubmit="return checkValue()">
	<table class="list">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="studentNo" maxlength="15" placeholder="학번을 입력하세요(9자리)" onchange="checkStudentNo(this);"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" maxlength="15" placeholder="비밀번호 입력(15자리 이하)"></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="password2" placeholder="비밀번호 확인"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" maxlength="20" placeholder="이름"></td>
		</tr>
		<tr>
			<td>학과</td>
			<td><select name="department" >
					<c:forEach items="${departments}" var="dpm">
						<option><c:out value="${dpm.id }"/> ${dpm.name } </option>
					</c:forEach>
			</select>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><input type="tel" name="phone"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" name="sex" value="남" checked>남
				<input type="radio" name="sex" value="여">여
			</td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td><button type="submit">회원가입</button></td>
		</tr>
	</table>
	
	<input type="hidden" id="departmentId" name = "departmentId" value="1">
</form>
</body>
</html>