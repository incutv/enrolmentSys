<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPEhtml>
<%@page import = "net.skhu.dto.res.ResStudent" %>
<%
	String name = (String)session.getAttribute("name");
	Integer studentId = (Integer)session.getAttribute("studentId");
	String studentNo = (String)session.getAttribute("studentNo");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Brand -->
	  <c:if test = "${not empty name}">
	 	 <a class="navbar-brand" href="#">학번 : ${studentNo} 이름 : ${ name }</a> 
	  </c:if>
	  <c:if test = "${empty name}">
	  	 <a class="navbar-brand" href="#">대학교시스템</a> 
	  </c:if>
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	    	<c:if test = "${not empty name}">
	      		<a class="nav-link" href="/student/logout">Logout</a>
	      		<a class="nav-link" href="/student/withdraw">회원탈퇴</a>
	      	</c:if>
	      	<c:if test = "${empty name }">
	      		<a class="nav-link" href="/student/login">Login</a>
	      	</c:if>
	    </li>
	    <c:if test = "${empty name }">
		    <li class="nav-item">
		      <a class="nav-link" href="/student/signup">Join</a>
		    </li>
		</c:if>
		
	    <!-- Dropdown -->
	    <li class="nav-item dropdown"> 
	      <div class="dropdown-menu">
	      	<a class="dropdown-item" href="/notice/list">공지사항</a>
	        <a class="dropdown-item" href="/sugang/list">수강신청</a>
	        <a class="dropdown-item" href="/sugang/studentList?id=${studentId }">수강신청내역</a>
	      </div>
	    </li>
	  </ul>
	</nav>
</body>
</html>
