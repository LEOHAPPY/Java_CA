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
	
	<form action="/WebShowcase/modifyProcess" method=post>

	<center>
	<h3>Set up Page for CRUD</h3><br>
<!-- 			<table cellpadding=4 cellspacing=2 border=0> -->
			<table width="50%" cellspacing=30>
			<thead>
				<tr>
					<th>Description</th>
					<th>Detail</th>
				</tr>
				</thead>
				<tr>
					<td>id</td>
					<td><c:if test="${param['insert']==t}">
							<input type="text" name="id" value="${param['id']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="false" /> 
							<!-- later in servlet to choose update/insert. [true: insert] [false: update]-->
						</c:if> 
						<c:if test="${param['update']==t}">
							<input type="text" name="id" value="${param['id']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="true" />
						</c:if></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name"
						value="${param['name']}" size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="email" name="email" value="${param['email']}"
						size=15 maxlength=20 required></td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="text" name="pw" value="${param['pw']}"
						size=15 maxlength=20 required></td>
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