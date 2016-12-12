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
	<h1><center>Grading</center></h1>
	<!-- content -->
		<table class="table">
				<thead class="thead-inverse">
		<tr><th>Course ID</th><th>Course Name</th><th>Course Start</th><th>Course MaxSize</th><th>&nbsp;</th><th>&nbsp;</th></tr>
		</thead>
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
	</div>
	</div>
</body>
</html>