<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer(Seller) Items Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h1>Welcome to Customer(Seller) Items Page</h1>
	<table border="1">
		<tr>
			<th>ITEM ID</th>
			<th>ITEM NAME</th>
			<th>ITEM COST</th>
			<th>CUSTOMER ID</th>
		</tr>
		<c:forEach items="${custItems}" var="ci">
			<tr>
				<td><c:out value="${ci.itemId }" /></td>
				<td><c:out value="${ci.itemName}" /></td>
				<td><c:out value="${ci.itemCost}" /></td>
				<td><c:out value="${ci.custId}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


