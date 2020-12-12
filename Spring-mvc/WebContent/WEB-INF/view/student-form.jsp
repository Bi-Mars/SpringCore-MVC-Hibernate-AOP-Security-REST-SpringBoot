<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!--  Add tag library for Spring MVC to use Spring Form Tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!--  Start HTML Document -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student Form </title>
</head>
<body>

<!--  Use Spring Form attribute. Make SURE the following Model Attribute MUST MATCH model we used in controller -->
<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" />
<br><br>
Last name: <form:input path="lastName" />
<br><br>
Country:
<form:select path="country">
	<form:options items="${student.countryOptions }" />
</form:select>
<br><br>
Favorite Langugae:
Java <form:radiobutton path="favoriteLanguage" value="Java"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
Golang <form:radiobutton path="favoriteLanguage" value="Golang"/>
R <form:radiobutton path="favoriteLanguage" value="R"/>

<br><br>

What operating systems are you familiar with?
 Linux <form:checkbox path="operatingSystems" value="linux"/> 
  Mac OS<form:checkbox path="operatingSystems" value="mac"/> 
  Windows <form:checkbox path="operatingSystems" value="window"/> 
 
<br><br>

<button type="submit"> Submit </button>


</form:form>


</body>
</html>