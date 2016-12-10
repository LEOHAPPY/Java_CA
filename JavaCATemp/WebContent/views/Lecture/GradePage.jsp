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
	<form method="POST" action="${pageContext.request.contextPath }/LecturerServlet/UpdateGrade">
			<table style="float: right" width="70%" border="1">
		<tr><th>Enrollment ID</th><th>Student ID</th><th>CourseID</th><th>CourseGrade</th>
		
		<c:forEach var="enrollment"  items="${requestScope.eList}" varStatus="Status"  >
		<tr>
		<td>${enrollment.enrollmentId }</td>
		<td>${enrollment.studentId }</td>
		<td>${enrollment.courseId }</td>
		<td><input type="text" name=${enrollment.enrollmentId } value=${enrollment.courseGrade }/></td>

		</tr>
		</c:forEach>
		<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td><input type="submit" value="Save" align="right" /></td></tr>
	</table>
	</form>
</body>
</html>