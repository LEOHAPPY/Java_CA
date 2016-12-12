<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
* {
	box-sizing: border-box;
}

.header
,
{
background-color
:
 
grey
;

    
color
:
 
white
;

    
padding
:
 
15
px
;


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
			<!-- content -->
			<h1>
				<center>Course Enrollment</center>
			</h1>
			<table class="table">
				<thead class="thead-inverse">

            <tr>
               <th> # </th>
                <th>CourseID</th>
                <th>Course Name</th>
                <th>Course Start Date</th>
                <th>Student Name</th>
                <th>Student Email</th>
               <th>Student Grade</th>
               <th>Status</th>
            </tr>
            </thead>
 <c:forEach var="course" items="${data}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                     <td class="nowrap">${status.index + 1}</td>
                    <td class="nowrap">${course.courseId}</td>
                    <td class="nowrap">${course.courseName}</td>
                    <td class="nowrap">${course.courseStart}</td>
<%--                     <td class="nowrap">${course.studentId}</td> --%>
                    <td class="nowrap">${course.studentName}</td>
                    <td class="nowrap">${course.studentEmail}</td>
                    <td class="nowrap">${(course.studentGrade eq "notset")? '-': course.studentGrade}</td>
                    <td class="nowrap">${(course.studentGrade eq "notset")? 'On-going': 'Completed'}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
        </div>
</body>
</html>