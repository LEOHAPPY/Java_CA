<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h1><center>Grade and GPA for Completed Courses</center></h1>

	<table class="table" >
  <thead class="thead-inverse">
        
            <tr>
               <th>#</th>
                <th>CourseID</th>
                <th>Course Name</th>
                <th>Course Start Date</th>
                <th>Course End Date</th>
                <th>Course Credit</th>
                <th>Course Grade</th>            
            </tr>
            </thead>
            
 <c:forEach var="grade" items="${grade}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index + 1}</td>
				<td class="nowrap">${grade.courseId}</td>
				<td class="nowrap">${grade.courseName}</td>
				<td class="nowrap">${grade.start}</td>
				<td class="nowrap">${grade.end}</td>

				<td class="nowrap">${grade.courseCredit}</td>
				<td class="nowrap">${grade.courseGrade}</td>
			</tr>
		</c:forEach>
            
            <tr><td><center>GPA</center></td>
            <td>${gpa}</td>
            <tr>
        </table>
        </div>
        </div>
</body>
</html>