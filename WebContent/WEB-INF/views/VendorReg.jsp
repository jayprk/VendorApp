<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Register</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h1 style="color: red; text-align: center">Welcome to Vendor Register Page!!</h1>
	<form action="insertVendor" method="post">
		<table align="center" frame="border" bordercolor="red">
			<tr>
				<td>ID</td>
				<td><input type="text" name="venId" /></td>
			</tr>
			<tr>
				<td>CODE</td>
				<td><input type="text" name="venCode" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="venName" /></td>
			</tr>
			<tr>
				<td>TYPE</td>
				<td><c:forEach items="${venTypesUi}" var="ob">
						<input type="radio" name="venType" value="${ob}">${ob}
	                </c:forEach></td>
			</tr>
			<tr>
				<td>LOCATION</td>
				<td><select name="loc.locId">
						<option value="">--select--</option>
						<c:forEach items="${locsUi}" var="locOb">
							<option value="${locOb.locId}">${locOb.locName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><textarea name="venAddrs"></textarea></td>
			</tr>
			<tr>
				<td>ID PROOF</td>
				<td><select name="venIdType">
						<option value="">--select--</option>
						<c:forEach items="${venIdTypesUi}" var="ob">
							<option value="${ob}">${ob}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>ID NUM</td>
				<td><input type="text" name="venIdNum" /></td>
			</tr>
			<tr>
				<td>NOTE</td>
				<td><textarea name="venDsc"></textarea></td>
			</tr>
			<tr style="text-align: center">
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form><br><br>
	<div style="color:green;text-align: center;font: bolder;">${Msg}</div>
</body>
</html>