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
	<p>set up page for CRUD</p>
	<!-- Add --><!-- Edit -->
	
	<form action="/WebShowcase/MCServlet/Update" method=post>

	<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
					<td>id</td>
					<td><c:if test="${!empty param['insert']}">
							<input type="text" name="id" value="${param['newCourseID']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="true" /> 
							<!-- later in servlet to choose update/insert. [true: insert] [false: update]-->
						</c:if> 
						<c:if test="${!empty param['update']}">
							<input type="text" name="id" value="${param['courseId']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="false" />
						</c:if></td>
				</tr>
				<tr>
					<td>courseName</td>
					<td><input type="text" name="courseName"
						value="${param['courseName']}" size=15 maxlength=20></td>
				</tr>
				<tr>
					<td>courseStart</td>
					<td><input type="text" name="courseStart" value="${param['courseStart']}"
						size=15 maxlength=20></td>
				</tr>
				<tr>
					<td>courseEnd</td>
					<td><input type="text" name="courseEnd" value="${param['courseEnd']}"
						size=15 maxlength=20></td>
				</tr>
				<tr>
					<td>courseCredit</td>
					<td><input type="text" name="courseCredit" value="${param['courseCredit']}"
						size=15 maxlength=20></td>
				</tr>
				<tr>
					<td>courseMaxSize</td>
					<td><input type="text" name="courseMaxSize" value="${param['courseMaxSize']}"
						size=15 maxlength=20></td>
				</tr>
				<tr>
					<td>courseDesc</td>
					<td><input type="text" name="courseDesc" value="${param['courseDesc']}"
						size=15 maxlength=20></td>
				</tr>
			</table>
		</center>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>
	
</body>
</html>