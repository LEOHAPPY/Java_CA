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
	<c:url var="addurl" scope="page"
		value="/views/Admin/SetUpPageCourse.jsp">
		<c:param name="newCourseID" value="${sessionScope.newCourseID }" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${addurl}">Add</a>
	
	<br />
	<br />

	<table style="float: left" class="borderAll" border="1px">
		<tr>
			<th>#</th>
			<th>courseId</th>
			<th>courseName</th>
			<th>courseStart</th>
			<th>courseEnd</th>
			<th>courseCredit</th>
			<th>courseMaxSize</th>
			<th>lecturerId</th>
			<th>Edit Delete</th>
		</tr>

		<c:forEach var="course" items="${requestScope.cList}"
			varStatus="status">
			<tr>
				<td class="nowrap">${status.index + 1}</td>
				<td class="nowrap">${course.courseId}</td>
				<td class="nowrap">${course.courseName}</td>
				<td class="nowrap">${course.courseStart}</td>
				<td class="nowrap">${course.courseEnd}</td>
				<td class="nowrap">${course.courseCredit}</td>
				<td class="nowrap">${course.courseMaxSize}</td>
				<td class="nowrap">${course.lectureId}</td>
				<!-- Edit -->
				<td class="nowrap"><c:url var="updurl" scope="page"
						value="/views/Admin/SetUpPageCourse.jsp">
						<c:param name="courseId" value="${course.courseId}" />
						<c:param name="courseName" value="${course.courseName}" />
						<c:param name="courseStart" value="${course.courseStart}" />
						<c:param name="courseEnd" value="${course.courseEnd}" />
						<c:param name="courseCredit" value="${course.courseCredit}" />
						<c:param name="lectureId" value="${course.lectureId}" />
						<c:param name="courseMaxSize" value="${course.courseMaxSize}" />
						<c:param name="courseDesc" value="${course.courseDesc}" />
						<c:param name="update" value="true" />
					</c:url> <a href="${updurl}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!-- Delete -->
					<!-- 				<c:url var="delurl" scope="page" value="/WebShowcase/MCServlet/Delete">
						<c:param name="courseId" value="${course.courseId}" />
					</c:url> <a href="${delurl}">Delete</a></td>
 -->
					<form method="POST" action="/WebShowcase/MCServlet/Delete">
						<input type="submit" value="Delete" /> <input type="hidden"
							name="courseId" value="${course.courseId}" />
					</form> 
					<%-- <c:url var="delurl" scope="page"
								value="/MCServlet/Delete">
	                            <c:param name="courseId" value="${course.courseId}" />
	                        </c:url>
	                        <a href="${delurl}">Delete</a> --%>
			</tr>
		</c:forEach>

	</table>

</body>
</html>