<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="checkToken.jsp" %>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New  city</title>
</head>
<body>
	<form action="../application/city?operation=addCity" method="post">
		<table>
				<tr>
					<td>Number:</td>
					<td><input type="text" id="number" name="number" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" id="name" name="name"  /></td>
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
			<tr><td><a href="../application/city?operation=back">Back</a></td></tr>
		</table>
	</form>

</body>
</html>