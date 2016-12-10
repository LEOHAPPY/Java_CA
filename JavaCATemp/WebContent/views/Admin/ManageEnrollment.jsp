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
		<tr>
			<td><%@ include file="SamePart.jsp"%></td>
		</tr>
	</table>

	<table style="float: right" border="1" class="borderAll">
		<tr>
			<th>#</th>
			<th>enrollmentId</th>
			<th>studentId</th>
			<th>courseId</th>
			<th>courseGrade</th>
		</tr>

		<c:forEach var="enrollment" items="${requestScope.eList}"
			varStatus="status">
			<tr>
				<td class="nowrap">${status.index + 1}</td>
				<td class="nowrap">${enrollment.enrollmentId}</td>
				<td class="nowrap">${enrollment.studentId}</td>
				<td class="nowrap">${enrollment.courseId}</td>
				<td class="nowrap">${enrollment.courseGrade}</td>
				<td class="nowrap"><c:url var="updurl" scope="page"
						value="/views/Admin/SetUpPageEnrollment.jsp">
						<c:param name="enrollmentId" value="${enrollment.enrollmentId}" />
						<c:param name="studentId" value="${enrollment.studentId}" />
						<c:param name="courseId" value="${enrollment.courseId}" />
						<c:param name="courseGrade" value="${enrollment.courseGrade}" />
						<c:param name="update" value="false" />
					</c:url> <a href="${updurl}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- Delete -->
					<!--				<c:url var="delurl" scope="page" value="/WebShowcase/MEServlet/Delete">
						<c:param name="enrollmentId" value="${enrollment.enrollmentId}" />
					</c:url> <a href="${delurl}">Delete</a></td>
				  -->
					<form method="POST" action="/WebShowcase/MEServlet/Delete">
						<input type="submit" value="Delete" /> <input type="hidden"
							name="enrollmentId" value="${enrollment.enrollmentId}" />
					</form>
			</tr>
		</c:forEach>
	</table>

	<c:url var="addurl" scope="page"
		value="/views/Admin/SetUpPageEnrollment.jsp">
		<c:param name="newEnrollmentID"
			value="${sessionScope.newEnrollmentID }" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${addurl}">Add</a>
</body>
</html>