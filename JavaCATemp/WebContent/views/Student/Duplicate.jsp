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
    width: 20%;
}
.content {
    width: 80%;
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

	<!-- content -->


	<center>
		<h3>Sorry you are unable to enroll for this course!</h3>
		<p>As the date clash with a course that you are currently enrolled
			in.</p>
		<table border=border>
			<tr>
				<th>#</th>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Course Start Date</th>
				<th>Course End Date</th>
			</tr>
			<tr>
				<td>Enrolled Course</td>
				<td>${overlapCourse.courseId}</td>
				<td>${overlapCourse.courseName}</td>
				<td>${overlapCourse.courseStart}</td>
				<td>${overlapCourse.courseEnd}</td>
			</tr>
			<tr>
				<td>New Course</td>
				<td>${newCourse.courseId}</td>
				<td>${newCourse.courseName}</td>
				<td>${newCourse.courseStart}</td>
				<td>${newCourse.courseEnd}</td>
			</tr>
		</table>
		<br>
		
		
		<c:if test="${canChange ==true }">		
			<center>	<p>
					Should you wish to change to the <b>${newCourse.courseName}</b>, you  will need to
					cancel your current course:<b>${overlapCourse.courseName}</b> through the Administration office.
					 <br> Do you want to change enrollment?
					<br>
				<center>
					<input type=button
						onclick="location.href='/WebShowcase/views/Student/EmailForm.jsp?email=${email}'"
						value="Yes"> <input type=button
						onclick="location.href='/WebShowcase/availablecourse'" value="No">
				</center>
				</p> </center>
			
		</c:if>

	</center>
	</div>
	</div>
</body>
</html>