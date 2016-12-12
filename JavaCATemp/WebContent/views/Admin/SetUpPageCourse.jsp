<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script><meta name="viewport" content="width=device-width, initial-scale=1">
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
<div class="clearfix">
  <div class="column menu">
		<%@ include file="SamePart.jsp"%>
	</div>
	<div class="column content">
	
	<!-- Add --><!-- Edit -->
	
	<form action="/WebShowcase/MCServlet/Update" method=post>

	<center>
		<h3>Set up Page for CRUD</h3><br>
<!-- 			<table cellpadding=4 cellspacing=2 border=0> -->
				<table width="50%" cellspacing=30>
				<thead>
				<tr>
					<th>Description</th>
					<th >Detail</th>
				</tr></thead>
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
						value="${param['courseName']}" size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>courseStart</td>
					<td><input type="date" name="courseStart" value="${param['courseStart']}"
						size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>courseEnd</td>
					<td><input type="date" name="courseEnd" value="${param['courseEnd']}"
						size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>courseCredit</td>
					<td><input type="text" name="courseCredit" value="${param['courseCredit']}"
						size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>courseMaxSize</td>
					<td><input type="text" name="courseMaxSize" value="${param['courseMaxSize']}"
						size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>lecturerId</td>
					<td><c:if test="${!empty param['insert']}">
							<select name="lecturerId">
								<c:forEach var="lecturer" items="${sessionScope.lListforCourse}"
									varStatus="status">
									<option value="${lecturer.id }">${lecturer.id }</option>
								</c:forEach>
							</select>
						</c:if> <c:if test="${!empty param['update']}">
							<select name="lecturerId">
								<c:forEach var="lecturer" items="${sessionScope.lListforCourse}"
									varStatus="status">
									<option value="${lecturer.id }">${lecturer.id }</option>
								</c:forEach>
							</select>
							<p>Current Lecturer: ${param['lectureId']}</p>
						</c:if></td>
				</tr>
				<tr>
					<td>courseDesc</td>
					<td><textarea style="resize: none" name="courseDesc" rows="8"
							cols="30">${param['courseDesc']}</textarea></td>

					<%-- 					<td><textarea rows="10" cols="15" name="courseDesc">"${param['courseDesc']}"</textarea> </td>
 --%>
				</tr>
 
			</table>
		</center>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>
	
	<script>
	$( "#myTable" ).validate();
	</script>
	</div>
	</div>
</body>
</html>