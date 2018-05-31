<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<form action="insertLoc" method="POST">
	<h2 style="color: red; text-align: center">Welcome to Location Registration page</h2>
		<table align="center" frame="border" bordercolor="red">
			
			<tr>
				<td >ID</td><td><input type="text" name="locId"></td>
			</tr>
			<tr>
				<td>NAME</td><td>  <input type="text" name="locName"></td>
			</tr>
			<tr>
				<td>TYPE </td><td> <input type="radio" name="locType" value=Urban>URBAN
					      <input type="radio" name="locType" value=Rural>RURAL
				</td>
			</tr>
			<tr>
				<td>CODE</td><td>  <input type="text" name="locCode"></td>
			<tr>
				<td>NOTE </td><td> <textarea name="locDesc"></textarea></td>
			</tr>
			<tr>
				<td style="text-align: center" colspan="2" ><br>
				   <input type="submit" value="Register" style="width: 129px;">
				</td>
			</tr>			
		</table>
	</form>
	<div style="color:red;text-align: center">${message}</div>
	
</body>
</html>