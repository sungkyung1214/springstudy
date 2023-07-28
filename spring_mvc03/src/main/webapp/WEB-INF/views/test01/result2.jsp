<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과보기 : ${str }</h1>
	<h1>수1: ${s1}</h1>
	<h1>수2: ${s2}</h1>
	<h1>연산자 : ${op }</h1>
	<h2>${s1}${op }${s1}=${str }</h2>
	<h2>${cPage }</h2>
		
	<c:forEach var="k" items="${hobby }">
		${k} 
	</c:forEach>
	<hr>
	<h2>${vo.s1}${vo.op }${vo.s2}=${str }</h2>
	<h2>${cPage }</h2>
		<c:forEach var="k" items="${vo.hobby }">
			<li>${k}</li> 
		</c:forEach>
	
	  
</body>
</html>