
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Customer Form</title>
<style>
	.error{
	color:red
	}
</style>
</head>
<body>
<h1> Customer Registration Form </h1>

<form:form action="processForm" modelAttribute="customer">
	
	First Name: <form:input path="firstName" />
	<br><br>
	
	Last Name: <form:input path="lastName" />
	<form:errors path="lastName" cssClass="error" />
	<br><br> 
	
	Free Passes: <form:input path="freePasses" />
	<form:errors path="freePasses" cssClass="error" />
	<br><br>
	
	Zip-code <form:input path="zipCode"/>
	<form:errors path="zipCode" cssClass="error" />
		<br><br>
		
	Course-code <form:input path="courseCode"/>
	<form:errors path="courseCode" cssClass="error" />
		<br><br>
	
	<button> Submit </button>
</form:form>

</body>
</html>