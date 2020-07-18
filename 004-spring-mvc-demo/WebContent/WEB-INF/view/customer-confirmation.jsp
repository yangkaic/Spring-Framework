<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	First Name: ${customer.firstName}
	<br><br>
	Last Name: ${customer.lastName} 
	
	<br><br>
	
	Free Passes: ${customer.freePasses}
	
	<br><br>
	Postal Code: ${customer.postalCode}
	
	<br><br>
	Course Code: ${customer.courseCode}
	
	<br><br>
	Sex: ${customer.sex}
</body>
</html>