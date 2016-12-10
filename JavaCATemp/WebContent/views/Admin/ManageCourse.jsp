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

	<!-- add -->
	<c:url var="url" scope="page" value="/views/Admin/SetUpPageCourse.jsp">
		<c:param name="courseId" value="" />
		<c:param name="courseName" value="" />
		<c:param name="courseStart" value="" />
		<c:param name="courseEnd" value="" />
		<c:param name="courseCredit" value="" />
		<c:param name="courseMaxSize" value="" />
		<c:param name="courseDesc" value="" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${url}">Add</a>
	<br />
	<br />

	<table class="borderAll">
		<tr>
			<th>#</th>
			<th>courseId</th>
			<th>courseName</th>
			<th>courseStart</th>
			<th>courseEnd</th>
			<th>courseCredit</th>
			<th>courseMaxSize</th>
			<th>courseDesc</th>
			<th>Edit Delete</th>
		</tr>

		<c:forEach var="course" items="${requestScope.aList}"
				varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${status.index + 1}</td>
                    <td class="nowrap">${course.courseId}</td>
                    <td class="nowrap">${course.courseName}</td>
                    <td class="nowrap">${course.courseStart}</td>
                    <td class="nowrap">${course.courseEnd}</td>
                    <td class="nowrap">${course.courseCredit}</td>
                    <td class="nowrap">${course.courseMaxSize}</td>
                    <td class="nowrap">${course.courseDesc}</td>
                    <!-- Edit -->
                    <td class="nowrap">
                        <c:url var="updurl" scope="page"
							value="/views/Admin/SetUpPageCourse.jsp">
                            <c:param name="courseId" value="${course.courseId}" />
                            <c:param name="courseName" value="${course.courseName}" />
                            <c:param name="courseStart"
								value="${course.courseStart}" />
                            <c:param name="courseEnd" value="${course.courseEnd}" />
                            <c:param name="courseCredit" value="${course.courseCredit}" />
                            <c:param name="courseMaxSize" value="${course.courseMaxSize}" />
                            <c:param name="courseDesc" value="${course.courseDesc}" />
                            <c:param name="update" value="false" />
                        </c:url>
                        <a href="${updurl}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        
                        <!-- Delete -->
                        <c:url var="delurl" scope="page"
							value="/deleteProcess">
                            <c:param name="courseId" value="${course.courseId}" />
                        </c:url>
                        <a href="${delurl}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
	</table>

</body>
</html>