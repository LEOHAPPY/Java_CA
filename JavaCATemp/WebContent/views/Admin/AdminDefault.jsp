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
I am silly boy
<table>
<tr><th>AdminID</th><th>AdminName</th><th>AdminEmail</th><th>AdminPw</th><th>login</th></tr>
<c:forEach var="person" items="${requestScope.person}" varStatus="status">
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