<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="checkToken.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New  city</title>
</head>
<body>
	<form action="../application/user?operation=saveUser" method="post">
		<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" id="username" name="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="text" id="password" name="password"  /></td>
				</tr>
				<tr>
					<td colspan="2">
					<c:out value="${requestScope.error}"></c:out>
					</td>
				</tr>

				<tr>
					<td><input type="submit" id="operation" name="operation" value="Save" /></td>
				</tr>
			</tbody>
			<tr><td><a href="../application/user?operation=back">Back</a></td></tr>
		</table>
	</form>

</body>
</html>