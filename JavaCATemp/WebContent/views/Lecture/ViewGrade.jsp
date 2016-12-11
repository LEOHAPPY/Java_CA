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
	<table style="float: left">
		<tr><td><%@ include file="SamePart.jsp"%></td></tr>
	</table>
	
			<table style="float: left" width="70%" border="1">
		<tr><th>Enrollment ID</th><th>Student ID</th><th>CourseID</th><th>CourseGrade</th>
		
		<c:forEach var="enrollment"  items="${requestScope.eList}" varStatus="Status"  >
		<tr>
		<td>${enrollment.enrollmentId }</td>
		<td>${enrollment.studentId }</td>
		<td>${enrollment.courseId }</td>
		<c:if test="${enrollment.courseGrade eq 'notset' }">
		<td></td>
		</c:if>
		<c:if test="${enrollment.courseGrade ne 'notset' }">
		<td>${enrollment.courseGrade }</td>
		</c:if>
		

		</tr>
		</c:forEach>
		
	</table>
</body>
</html>