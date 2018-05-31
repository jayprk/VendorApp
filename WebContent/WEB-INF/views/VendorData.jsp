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
	<h1 style="color: red; text-align: center">Welcome to Vendor Data Page</h1>
	<table align="center" frame="border" bgcolor="lightyellow" bordercolor="green" border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th>LOCATION</th>
			<th>LOC TYPE</th>
			<th>VEN TYPE</th>
			<th>ADDRESS</th>
			<th>ID TYPE</th>
			<th>ID NUM</th>
			<th>NOTE</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${Vens}" var="ven">
			<tr>
				<td>${ven.venId}</td>
				<td>${ven.venName}</td>
				<td>${ven.venCode}</td>
				<td>${ven.loc.locName}</td>
				<td>${ven.loc.locType}</td>
				<td>${ven.venType}</td>
				<td>${ven.loc.locName}</td>
				<td>${ven.venIdType}</td>
				<td>${ven.venIdNum}</td>
				<td>${ven.venDsc}</td>
				<td><a href="deleteVender?venId=${ven.venId}"><img
						src="../Images/LocationDelete.png" width="25" height="25" /></a>&nbsp;&nbsp;&nbsp;
					<a href="editVender?venId=${ven.venId}"><img
						src="../Images/LocationEdit.png" width="25" height="25" /></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<a href="venExelExport">Get Records in Excel Format</a>
	<br>
	<br>
	<a href="venPdfExport">Get Records in PDF Format</a>
	<br>
	<br>
	<a href="venReport">Get Records in Charts Format</a>
	<br>
	<br>
	<a href="venHome">Go Back to Registration Page</a>
</body>
</html>