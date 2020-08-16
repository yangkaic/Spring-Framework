<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Spring REST Demo
<hr>

<a href="${pageContext.request.contextPath}/test/hello">Hello</a>

<br><br>

<a href="${pageContext.request.contextPath}/api/students">List All Students</a>

<br><br>

<a href="${pageContext.request.contextPath}/api/books">List All Books</a>



</body>
</html>