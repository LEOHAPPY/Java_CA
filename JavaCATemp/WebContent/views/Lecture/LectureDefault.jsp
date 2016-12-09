<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- left navigation -->
	<table style="float: left">
		<td><%@ include file="SamePart.jsp"%></td>
	</table>

	<!-- content -->
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Pw</th>
			<th>login</th>
		</tr>   
     <tr>Username from session:<c:out value="${sessionScope.profile.id}"/></tr>
		<c:forEach var="person" items="${requestScope.aList}"
			varStatus="status">
			<tr>
				<td>${person.id}</td>
				<td>${person.name}</td>
				<td>${person.email}</td>
				<td>${person.pw}</td>
				<td>${person.id}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>