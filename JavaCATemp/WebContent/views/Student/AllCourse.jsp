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
	<table style="float: left" width=20%>
		<td><%@ include file="SamePart.jsp"%></td>
	</table>

	<!-- content -->


	<table class="borderAll" border="1">
		<tr>
			<td colspan=8><h1>
					<center>Courses</center>
				</h1></td>
		<tr>
		<tr>
			<th>#</th>
			<th>CourseID</th>
			<th>Course Name</th>
			<th>Course Start Date</th>
			<th>Course End Date</th>
			<th>Course Credit</th>
			<th>Course Maximum Size</th>
			<th>Course Description</th>


		</tr>

		<c:forEach var="course" items="${course}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index + 1}</td>
				<td class="nowrap">${course.courseId}</td>
				<td class="nowrap">${course.courseName}</td>
				<td class="nowrap">${course.courseStart}</td>
				<td class="nowrap">${course.courseEnd}</td>
				<td class="nowrap">${course.courseCredit}</td>
				<td class="nowrap">${course.courseMaxSize}</td>
				<td class="nowrap">${course.courseDesc}</td>


			</tr>
		</c:forEach>
	</table>


	<table border="1" cellpadding="5" cellspacing="5" align=center>
		<tr>
			<%--For displaying Previous link except for the 1st page --%>
			<c:if test="${currentPage != 1}">
				<td><a href="allcourse?page=${currentPage - 1}">Previous</a></td>
			</c:if>

			<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>


			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="allcourse?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>


			<%--For displaying Next link --%>
			<c:if test="${currentPage lt noOfPages}">
				<td><a href="allcourse?page=${currentPage + 1}">Next</a></td>
			</c:if>
		</tr>
	</table>
</body>
</html>