<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Landing Page</title>


<body>


	<h2>Welcome to my home page!</h2>
	<hr>
	<p>Welcome to he langind page! This page is open to the public ...
		stay tuned!</p>

	<p>
		<a href="${pageContext.request.contextPath}/employees">Access
			Secure Site(Login Required)</a>
	</p>
</body>
</html>