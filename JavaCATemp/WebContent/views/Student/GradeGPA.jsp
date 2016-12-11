<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<table class="borderAll" border="1px">
        <tr ><td colspan=8><h1><center>Grade And GPA for Completed Courses</center></h1></td><tr>
            <tr>
               <th>#</th>
                <th>CourseID</th>
                <th>Course Name</th>
                <th>Course Start Date</th>
                <th>Course End Date</th>
                <th>Course Credit</th>
                <th>Course Grade</th>            
            </tr>
            
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
</body>
</html>