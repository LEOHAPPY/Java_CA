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
		<tr><td><%@ include file="SamePart.jsp"%></td></tr>
	</table>

	<!-- content -->
		<table style="float: right" width="70%" border="1">
		<tr><th>Course ID</th><th>Course Name</th><th>Course Start</th><th>Course MaxSize</th><th>&nbsp;</th><th>&nbsp;</th></tr>
		
		<c:forEach var="course"  items="${requestScope.cList}" varStatus="Status"  >
		<tr>
		<td>${course.courseId }</td>
		<td>${course.courseName }</td>
		<td>${course.courseStart }</td>
		<td>${course.courseMaxSize }</td>
		<td><form method="post" action="${pageContext.request.contextPath }/LecturerServlet/View"><input type="submit" value="View"/><input type="hidden" name="id" value=${course.courseId } /></form></td>
		<td><form method="post" action="${pageContext.request.contextPath }/LecturerServlet/Grade"><input type="submit" value="Grade"/><input type="hidden" name="id" value=${course.courseId } /></form></td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>