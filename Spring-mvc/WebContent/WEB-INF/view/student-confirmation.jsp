<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Student Confirmation</title>
</head>
<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>
Country: ${student.country}
<br><br>

Favorite Language: ${student.favoriteLanguage}

<br> <br>
operating systems:
<ul>
	<c:forEach var="eachOS" items="${student.operatingSystems}">
		<li> ${eachOS}</li>
	</c:forEach>
</ul>
</body>
</html>