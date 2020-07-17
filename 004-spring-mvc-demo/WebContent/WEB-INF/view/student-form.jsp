<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName" />
		<br><br>
		
		Last Name: <form:input path="lastName" />
		
		<br><br>
		
		Country: <form:select path="country">
					<form:option value="Brazil" label="Brazil" />
					<form:option value="USA" label="USA" />
					<form:option value="China" label="China" />
				</form:select>
		<br><br>
		
		Secondary Country: <form:select path="secondaryCountry">
					<form:options items="${student.secondaryCountryOptions}" />
				</form:select>
		<br><br>
		
		Third Country: <form:select path="thirdCountry">
					<form:options items="${thirdCountryOptions}" />
				</form:select>
		<br><br>
		
		My Programming Language:<br><br>
		
		Java <form:radiobutton path="myProgrammingLanguage" value="Java"/>
		C++ <form:radiobutton path="myProgrammingLanguage" value="C++"/>
		Python <form:radiobutton path="myProgrammingLanguage" value="Python"/>
		
		<br><br>
		
		My Secondary Programming Language:<br><br>
		
		<form:radiobuttons path="mySecondaryProgrammingLanguage" items="${student.secondaryProgrammingLanguageOptions}" />
		
		<br><br>
		
		Operating Systems:<br><br>
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		<br><br>
		
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>