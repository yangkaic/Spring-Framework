<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation</title>
</head>
<body>

	First Name: ${student.firstName}
	<br><br>
	
	Last Name: ${student.lastName}
	
	<br><br>
	
	Country: ${student.country}
	
	<br><br>
	
	Secondary Country: ${student.secondaryCountry}
	
	<br><br>
	
	Third Country: ${student.thirdCountry}
	
	<br><br>
	
	My Programming Language: ${student.myProgrammingLanguage}
	
	<br><br>
	
	My Secondary Programming Language: ${student.mySecondaryProgrammingLanguage }
	
	<br><br>
	
	Operating Systems:
	
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
	

</body>
</html>