<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
th {
	color: blue;
}
</style>
</head>
<body>
<%@include file="UserMenu.jsp"%>
	<h1 style="color: red; text-align: center">Welcome to Customer
		Data page!!</h1>
    
	<table align="center" frame="border" bgcolor="lightyellow" bordercolor="green" border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>LOCATION</th>
			<th>EMAIL</th>
			<th>TYPE</th>
			<th>ADDRESS</th>
			<th>OPERATION</th>
		</tr>
		<c:forEach items="${custs}" var="cust">
			<tr>
				<td><c:out value="${cust.custId}" /></td>
				<td><c:out value="${cust.custName}" /></td>
				<td><c:out value="${cust.loc.locName}" /></td>
				<td><c:out value="${cust.custEmail}" /></td>
				<td><c:out value="${cust.custType}" /></td>
				<td><c:out value="${cust.custAddrs}" /></td>
				<td><a href="deleteCust?custId=${cust.custId}"><img
						src="../Images/LocationDelete.png" width="25" height="25"
						onclick="return confirm('Customer Id::${cust.custId}\nAre you sure you want to delete this Data?')" /></a>&nbsp;&nbsp;&nbsp;
					<a href="editCust?customerId=${cust.custId}"><img
						src="../Images/LocationEdit.png" width="25" height="25" /></a></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<br>
</body>
</html>