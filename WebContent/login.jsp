<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set value="${pageContext.request.contextPath}"  var="contextPath"></c:set>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<jsp:useBean id="credentials" class="domain.User" scope="request">
		<jsp:setProperty name="credentials" property="username" value=""/>
		<jsp:setProperty name="credentials" property="password" value=""/>
	</jsp:useBean>
	
	<form action="${contextPath}/application/login" method="post">
		<table>
			<tbody>
				<tr>
					<td>Username:</td>
					<td><input type="text" id="username" name="username" value='<jsp:getProperty property="username" name="credentials"/>'/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" id="password" name="password" value='<jsp:getProperty property="password" name="credentials"/>' /></td>
				</tr>
				<tr>
					<td colspan="2">
					<c:out value="${requestScope.error}"></c:out>
					</td>
				</tr>

				<tr>
					<td><input type="submit" id="login" name="login" value="Login" /></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>