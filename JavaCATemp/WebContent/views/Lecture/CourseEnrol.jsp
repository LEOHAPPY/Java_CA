<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<!-- content -->
	<table class="borderAll" border="1px" style="width: 75%">
	<tbody style=" text-align: center">
        <tr ><td colspan=8><h1><center>Course Enrollment</center></h1></td><tr>
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
            
 <c:forEach var="course" items="${data}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                     <td class="nowrap">${status.index + 1}</td>
                    <td class="nowrap">${course.courseId}</td>
                    <td class="nowrap">${course.courseName}</td>
                    <td class="nowrap">${course.courseStart}</td>
<%--                     <td class="nowrap">${course.studentId}</td> --%>
                    <td class="nowrap">${course.studentName}</td>
                    <td class="nowrap">${course.studentEmail}</td>
                    <td class="nowrap">${empty course.studentGrade? '-': course.studentGrade}</td>
                    <td class="nowrap">${empty course.studentGrade? 'On-going': 'Completed'}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</body>
</html>