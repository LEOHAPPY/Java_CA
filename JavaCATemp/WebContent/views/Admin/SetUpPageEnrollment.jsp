<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<p>set up page for CRUD</p>
	<!-- Add -->
	<!-- Edit -->

	<form action="/WebShowcase/MEServlet/Update" method=post>

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
					<td>enrollmentId</td>
					<td><c:if test="${!empty param['insert']}">
							<input type="text" name="id" value="${param['newEnrollmentID']}"
								size=15 maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="true" />
							<!-- later in servlet to choose update/insert. [true: insert] [false: update]-->
						</c:if> <c:if test="${!empty param['update']}">
							<input type="text" name="id" value="${param['enrollmentId']}"
								size=15 maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="false" />
						</c:if></td>
				</tr>

				<tr>
					<td>studentId</td>
					<td><c:if test="${!empty param['insert']}">
							<select name="studentId">
								<c:forEach var="student"
									items="${sessionScope.sListForEnrollment}" varStatus="status">
									<option value="${student.id }">${student.id }</option>
								</c:forEach>
							</select>
						</c:if> <c:if test="${!empty param['update']}">
							<select name="studentId">
								<option value="${param['studentId']}">${param['studentId']} </option>
							</select>
						</c:if></td>
				</tr>

				<tr>
					<td>courseId</td>
					<td><c:if test="${!empty param['insert']}">
							<select name="courseId">
								<c:forEach var="course"
									items="${sessionScope.cListForEnrollment}" varStatus="status">
									<option value="${course.courseId }">${course.courseId }</option>
								</c:forEach>
							</select>
						</c:if> <c:if test="${!empty param['update']}">
							<select name="courseId">
								<option value="${param['courseId']}">${param['courseId']}</option>
							</select>
						</c:if></td>
				</tr>

				<tr>
					<td>courseGrade</td>
					<c:choose>
						<c:when test="${param['courseGrade']=='A'}">
							<td><select name="courseGrade">
									<option selected="selected" value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
									<option value=""></option>
							</select></td>
						</c:when>

						<c:when test="${param['courseGrade']=='B'}">
							<td><select name="courseGrade">
									<option value="A">A</option>
									<option selected="selected" value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
									<option value=""></option>
							</select></td>
						</c:when>

						<c:when test="${param['courseGrade']=='C'}">
							<td><select name="courseGrade">
									<option value="A">A</option>
									<option value="B">B</option>
									<option selected="selected" value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
									<option value=""></option>
							</select></td>
						</c:when>

						<c:when test="${param['courseGrade']=='D'}">
							<td><select name="courseGrade">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option selected="selected" value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
									<option value=""></option>
							</select></td>
						</c:when>

						<c:when test="${param['courseGrade']=='E'}">
							<td><select name="courseGrade">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option selected="selected" value="E">E</option>
									<option value="F">F</option>
									<option value=""></option>
							</select></td>
						</c:when>

						<c:when test="${param['courseGrade']=='F'}">
							<td><select name="courseGrade">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option selected="selected" value="F">F</option>
									<option value=""></option>
							</select></td>
						</c:when>

						<c:when test="${empty param['courseGrade']}">
							<td><select name="courseGrade">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="E">E</option>
									<option value="F">F</option>
									<option selected="selected" value=""></option>
							</select></td>
						</c:when>
					</c:choose>
				</tr>
			</table>
		</center>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>
	
	<script>
	$( "#myTable" ).validate();
	</script>

</body>
</html>