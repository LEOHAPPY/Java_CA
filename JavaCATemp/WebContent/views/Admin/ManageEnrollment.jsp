<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
* {
    box-sizing: border-box;
}
.header, {
    background-color: grey;
    color: white;
    padding: 15px;
}
.column {
    float: left;
    padding: 15px;
}
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
.menu {
    width: 25%;
}
.content {
    width: 75%;
}

</style>
<title>Insert title here</title>
</head>
<body>
	<!-- left navigation -->
	<div class="clearfix">
  <div class="column menu"><%@ include file="SamePart.jsp"%></div>
<div class="column content">
	<c:url var="addurl" scope="page"
		value="/views/Admin/SetUpPageEnrollment.jsp">
		<c:param name="newEnrollmentID"
			value="${sessionScope.newEnrollmentID }" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${addurl}">Add</a>
	
	<br />
	<br />

	<table class="table" >
  <thead class="thead-inverse">
		<tr>
			<th>#</th>
			<th>enrollmentId</th>
			<th>studentId</th>
			<th>courseId</th>
			<th>courseGrade</th>
			<th>Edit Delete</th>
		</tr>
</thead>
		<c:forEach var="enrollment" items="${requestScope.eList}"
			varStatus="status">
			<tr>
				<td class="nowrap">${status.index + 1}</td>
				<td class="nowrap">${enrollment.enrollmentId}</td>
				<td class="nowrap">${enrollment.studentId}</td>
				<td class="nowrap">${enrollment.courseId}</td>
				<c:if test="${enrollment.courseGrade eq 'notset'}">
					<td class="nowrap"></td>
				</c:if>
				<c:if test="${enrollment.courseGrade ne 'notset'}">
					<td class="nowrap">${enrollment.courseGrade}</td>
				</c:if>
					
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
						<%-- <c:url var="delurl" scope="page"
								value="/MEServlet/Delete">
	                            <c:param name="enrollmentId" value="${enrollment.enrollmentId}" />
	                        </c:url>
	                        <a href="${delurl}">Delete</a> --%>
			</tr>
		</c:forEach>
	</table>
</div>
</div>
	
</body>
</html>