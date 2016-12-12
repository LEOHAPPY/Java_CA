<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
  <div class="column menu">
		<%@ include file="SamePart.jsp"%>
	</div>
	<div class="column content">
	
			<table class="table">
				<thead class="thead-inverse">
		<tr><th>Enrollment ID</th><th>Student ID</th><th>CourseID</th><th>CourseGrade</th>
		</tr>
		</thead>
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
	</div>
	</div>
</body>
</html>