<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h1 style="color: red; text-align: center">Welcome to Customer
		Registration page!!</h1>
	<form action="insertCust" method="POST">
		<table align="center" frame="border" bordercolor="red">
			<tr>
				<td>ID</td>
				<td><input type="text" name="custId" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="custName" /></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="text" name="custEmail" /></td>
			</tr>
			<tr>
				<td>TYPE</td>
				<td><select name="custType">
						<option value="">---select---</option>
						<c:forEach items="${custTypesUi}" var="ob">
							<option value="${ob}">${ob}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><textarea name="custAddrs"></textarea></td>
			</tr>
			<tr style="text-align: center">
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
	${message}
</body>
</html>