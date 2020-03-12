<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="../checkToken.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error page</title>
</head>
<body>
		<p>Mapiranje <c:out value="${requestScope.error}"/> ne postoji</p>
		
		<a href="../application/home">Home</a>
</body>
</html>