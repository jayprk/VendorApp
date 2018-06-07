<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Edit</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h1 style="color: red; text-align: center">Welcome to Vendor Edit
		Page!!</h1>
	<form action="updateVen" method="post">
		<table align="center" frame="border" bordercolor="red">
			<tr>
				<td>ID</td>
				<td><input type="text" name="venId" value="${ven.venId}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>CODE</td>
				<td><input type="text" name="venCode" value="${ven.venCode}" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="venName" value="${ven.venName}" /></td>
			</tr>
			<tr>
				<td>Location</td>
				<td><select name="loc.locId">
						<option value="-1">--select--</option>
						<c:forEach items="${locsUi}" var="locOb">
							<c:choose>
								<c:when test="${ven.loc.locId eq locOb.locId }">
									<option value="${locOb.locId}" selected="selected">${locOb.locName}</option>
								</c:when>
								<c:otherwise>
									<option value="${locOb.locId}">${locOb.locName}</option>
								</c:otherwise>
							</c:choose>


						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>TYPE</td>
				<td>
				  <c:forEach items="${venTypesUi}" var="ob">
						<c:choose>
							<c:when test="${ven.venType eq ob}">
								<input type="radio" name="venType" value="${ob}" checked="checked">${ob}
		                	</c:when>
		                	
							<c:otherwise>
								<input type="radio" name="venType" value="${ob}">${ob}
		 	                </c:otherwise>
						</c:choose>
				 </c:forEach>
			 </td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><textarea name="venAddrs">${ven.venAddrs}</textarea></td>
			</tr>
			<tr>
				<td>ID PROOF</td>
				<td><select name="venIdType">
						<option value="">--select--</option>

						<c:forEach items="${venIdTypesUi}" var="ob">
							<c:choose>
								<c:when test="${ven.venIdType eq ob}">
									<option value="${ob}" selected="selected">${ob}</option>
								</c:when>
								<c:otherwise>
									<option value="${ob}">${ob}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td>ID NUM</td>
				<td><input type="text" name="venIdNum" value="${ven.venIdNum}" /></td>
			</tr>
			<tr>
				<td>NOTE</td>
				<td><textarea name="venDsc">${ven.venDsc}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>