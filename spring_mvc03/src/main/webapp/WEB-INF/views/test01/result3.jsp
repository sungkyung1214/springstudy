<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과보기</h2>
	<h3>
	<li>올린사람 : ${name }</li>
	<li>원본파일이름 : ${f_name}</li>
	<li>저장된파일이름 : ${f_name2 }</li>
	<li>파일타입 : ${file_type}</li>
	<li>사진 사이즈 : ${size }KB</li>
	<li>날짜 : ${lastday}</li>
	<li><img src="resources/images/${f_name2}" style="width: 150px;"></li>
	</h3>
	
</body>
</html>