<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	th{
		color:blue;
	}
</style>
</head>
<body>
<%@include file="UserMenu.jsp"%>
	<h1 style="color:red;text-align: center">Welcome to LocationData page!!</h1>
	
	<table align="center" frame="border" bgcolor="lightyellow" bordercolor="green" border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th>TYPE</th>
			<th>DESCRIPTION</th>
			<th>OPERATION</th>
		</tr>
		<c:forEach items="${Locs}" var="loc">
			<tr>
				<td><c:out value="${loc.locId}" /></td>
				<td><c:out value="${loc.locName}" /></td>
				<td><c:out value="${loc.locCode}" /></td>
				<td><c:out value="${loc.locType}" /></td>
				<td><c:out value="${loc.locDesc}" /></td>
				<td><a href="deleteLoc?locId=${loc.locId}"><img src="../Images/LocationDelete.png" width="25" height="25"
				       onclick="return confirm('Location Id::${loc.locId}\nAre you sure you want to delete this Data?')"/></a>&nbsp;&nbsp;&nbsp;
				    <a href="editLoc?locationId=${loc.locId}"><img src="../Images/LocationEdit.png" width="25" height="25"/></a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="locExcelExport">Get Records in Excel Format</a><br><br>
	<a href="locPdfExport">Get Records in Pdf Format</a><br><br>
	<a href="locReport">Get Records in Charts Format</a>
	
	<br>
	<br>
	<a href="locHome"><b>Go Back to Registration Page</b></a>
</body>
</html>