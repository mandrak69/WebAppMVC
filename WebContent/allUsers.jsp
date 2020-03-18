<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="../application/user" method="post">
		<table>
			<tr>
				<td><c:out value="${sessionScope.loginMessage}"></c:out></td>
				<td><a href="../application/login">Log out</a></td>
			</tr>
			<tr>
				<td>username</td>
				<td>pass</td>
			</tr>
			<c:forEach items="${applicationScope.users}" var="user">

				<c:url value="../application/user" var="editURL">
					<c:param name="operation" value="edit" />
					<c:param name="username" value="${user.username}" />
				</c:url>
				
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td><a href="<c:out value = "${editURL}"/>">Edit</a></td>
					<td><a href="<c:out value = "${removeURL}"/>">Remove</a></td>

				</tr>
			</c:forEach>
			<tr>
				<td><c:out value="${requestScope.listIsEmpty}"></c:out></td>
			</tr>
			<tr>
				<td><a href="../application/user?operation=back">Back</a></td>
			</tr>
		</table>
	</form>

</body>
</html>