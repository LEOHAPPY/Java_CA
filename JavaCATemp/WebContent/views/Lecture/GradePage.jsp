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
	<form method="POST"
		action="${pageContext.request.contextPath }/LecturerServlet/UpdateGrade">
		<table class="table">
				<thead class="thead-inverse">
			<tr>
				<th>Enrollment ID</th>
				<th>Student ID</th>
				<th>CourseID</th>
				<th>CourseGrade</th>
			</tr>
			</thead>
				<c:forEach var="enrollment" items="${requestScope.eList}"
					varStatus="Status">
					<tr>
						<td>${enrollment.enrollmentId }</td>
						<td>${enrollment.studentId }</td>
						<td>${enrollment.courseId }</td>

						<c:choose>
							<c:when test="${enrollment.courseGrade=='A'}">
								<td><select name=${enrollment.enrollmentId }>
										<option selected="selected" value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option value="notset"></option>
								</select></td>
							</c:when>

							<c:when test="${enrollment.courseGrade=='B'}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option selected="selected" value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option value=""></option>
								</select></td>
							</c:when>

							<c:when test="${enrollment.courseGrade=='C'}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option value="B">B</option>
										<option selected="selected" value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option value="notset"></option>
								</select></td>
							</c:when>

							<c:when test="${enrollment.courseGrade=='D'}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option selected="selected" value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option value="notset"></option>
								</select></td>
							</c:when>

							<c:when test="${enrollment.courseGrade=='E'}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option selected="selected" value="E">E</option>
										<option value="F">F</option>
										<option value=""></option>
								</select></td>
							</c:when>

							<c:when test="${enrollment.courseGrade=='F'}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option selected="selected" value="F">F</option>
										<option value="notset"></option>
								</select></td>
							</c:when>
							
							<c:when test="${enrollment.courseGrade eq 'notset'}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option selected="selected" value="notset"></option>
								</select></td>
							</c:when>

							<c:when test="${empty enrollment.courseGrade}">
								<td><select name=${enrollment.enrollmentId }>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D">D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option selected="selected" value="notset"></option>
								</select></td>
							</c:when>
						</c:choose>

					</tr>
				</c:forEach>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save" align="right" /></td>
			</tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>