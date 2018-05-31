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
<h1 style="color: red; text-align: center">Welcome to Customer Edit Page!!</h1>
	<form action="updateCust" method="POST">
		<table align="center" frame="border" bordercolor="red">
			<tr>
				<td>Customer ID:</td><td><input type="text" name="custId" value="${custs.custId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Customer Name:</td><td><input type="text" name="custName" value="${custs.custName}"></td>
			</tr>
			<tr>
				<td>Customer Mail:</td><td><input type="text" name="custEmail" value="${custs.custEmail}"></td>
			</tr>
			<tr>
				<td>Customer Type:</td><td>
					<c:choose>
						<c:when test="${'CONSUMER' eq custs.custType}">
							<select>
								<option selected="selected">CONSUMER</option>
								<option>SELLER</option>
							</select>
						</c:when>
						<c:otherwise>
							<select>
								<option>CONSUMER</option>
								<option selected="selected">SELLER</option>
							</select>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
			<tr>
				<td>Customer Address:</td><td><textarea name="custAddrs">${custs.custAddrs}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update" style="width: 137px; "></td>
			</tr>
		</table>
	</form>
</body>
</html>