<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp"%>
<h1 style="color: red; text-align: center">Welcome to Location Edit Page!!</h1>
	<form action="updateLoc" method="POST">
		<table align="center" frame="border" bordercolor="red">
			<tr>
				<td>Location ID:</td><td><input type="text" name="locId" value="${locs.locId}"></td>
			</tr>
			<tr>
				<td>Location Name:</td><td><input type="text" name="locName" value="${locs.locName}"></td>
			</tr>
			<tr>
				<td>Location Type:</td><td>
					<c:choose>
						<c:when test="${'Urban' eq locs.locType}">
							<input type="radio" name="locType" value="Urban" checked="checked">Urban  |
							<input type="radio" name="locType" value="Rural">Rural
						</c:when>
						<c:otherwise>
							<input type="radio" name="locType" value="Urban">Urban |
							<input type="radio" name="locType" value="Rural" checked="checked">Rural
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>Location Code:</td><td><input type="text" name="locCode" value="${locs.locCode}"></td>
			</tr>
			<tr>
				<td>Location Description:</td><td><textarea name="locDesc">${locs.locDesc}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update" style="width: 137px; "></td>
			</tr>
		</table>
	</form>
</body>
</html>