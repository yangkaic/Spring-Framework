<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>

<!-- reference our style sheet -->
<link type="text/css"
 rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css" />
 
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manger</h2>
	</div>
</div>


<div id="container">
	<div id="content">
	
	<!-- put new button: Add Customer -->
	<input type="button" value="Add Customer" 
	onclick="window.location.href='showFormForAdd'; return false;" 
	class="add-button" />
	
	<!-- Add a search box -->
	<form:form action="search" method="GET">
	
	Search Customer: <input type="text" name="searchName" />
	
	<input type="submit" value="Search" class="add-button" />
	
	</form:form>
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="customer" items="${customers}">
				
				<!-- construct an "update" link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
			
				<!-- construct a "delete" link with customer id -->
				<c:url var="deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
				
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					
					<td>
						<!-- display the update link -->
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" 
						onclick="if (!(confirm('Are you sure you want to delte this customer?'))) return false">Delete</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
		
		<div style="clear; both;">
	
	</div>
	
	<p>
		<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
	</p>
	
	</div>

</div>

</body>
</html>