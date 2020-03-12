<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="checkToken.jsp" %>
    <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit city</title>
</head>
<body>
<form action="../application/city?operation=editcity" method="post">
		<table>
			<tbody>
				<tr>
					<td>Number:</td>
					<td><c:out value="${requestScope.number}"/><input type="text" id="number" name="number" value="${requestScope.number}" hidden="false" /></td>
					
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" id="name" name="name"  /></td>
				</tr>

				<tr>
					<td><input type="submit" id="editcity" name="editcity" value="editcity" /></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>