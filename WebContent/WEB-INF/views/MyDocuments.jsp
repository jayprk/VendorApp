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
		color: blue;
	}
</style>
</head>
<body>
<%@include file="UserMenu.jsp"%>
	<h1 style="color: red;text-align: center;">Welcome to My Document page!!</h1>
	<form action="docUpload" method="POST" enctype="multipart/form-data">
		<table align="center" frame="border" bordercolor="red">
		<tr>
		<td>ID</td><td><input type="text" name="docId"></td>
		</tr>
		<tr>
		<td>Choose File</td><td><input type="file" name="docData"></td>
		</tr>
		<tr>
		<td colspan="2" align="center"><input type="submit" value="Upload"><td>
		</tr>
	</table>
	</form>
	<br><br><br><br>
	<table align="center" border="1" frame="border" bordercolor="red">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DOWNLOAD</th>
		</tr>
		<c:forEach items="${docs}" var="doc">
			<tr>
				<td><c:out value="${doc[0]}" /></td>
				<td><c:out value="${doc[1]}" /></td>
				<td><a href="docDownload?docId=${doc[0]}">Download</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>