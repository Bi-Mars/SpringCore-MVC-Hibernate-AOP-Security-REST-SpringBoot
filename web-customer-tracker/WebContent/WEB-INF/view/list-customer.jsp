<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers </title>
<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2> CRM - CUSTOMER RELATIONSHIP MANAGER</h2>
	</div>
</div>

<div id="container">
<div id="content">
	<!--  Button to add customer -->
	<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"
	/> <!-- "showFormForAdd" call Spring Controller Mapping -->
	
	<!--  Add HTML TABLE -->
	<table>
		<tr> 
			<th> First Name </th>
			<th> Last Name </th>
			<th> Email Name </th>
			<th> Action </th>
		</tr>
		
		<!--  Loop over and print out customer -->
		<c:forEach var="tempCustomer" items="${customers }">
		
		<!--  Construct an "Update Link" with customer id -->
		<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomer.id}" />
		</c:url>
			<tr>
				<td> ${tempCustomer.firstName} </td>
				<td> ${tempCustomer.lastName} </td>
				<td> ${tempCustomer.email} </td>
				<td> 
					<!--  Display the update link - Use variable defined above -->
					<a href="${updateLink}"> Update </a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</div>

</body>
</html>