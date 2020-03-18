<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<jsp:useBean id="credentials" class="domain.User" scope="request">
		<jsp:setProperty name="credentials" property="username" value="" />
		<jsp:setProperty name="credentials" property="password" value="" />
	</jsp:useBean>
	.
	<div class="dropdown-content">
		<a href="${contextPath}/application/user?operation=allUsers">Show
			users</a> </br> <a href="${contextPath}/application/user?operation=addUser">Add
			user</a> </br> <a href="${contextPath}/application/login">LogIn</a> </br> <a
			href="${contextPath}/application/home">Glavni menu</a> </br> <a href="#">Help</a>
	</div>



</body>
</html>

</div>
</div>


