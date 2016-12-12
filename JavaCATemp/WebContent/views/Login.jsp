<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<center>
		<h3>Login Form</h3>
	</center>
	<%-- <center>${error}</center> --%>
	<table width="100%">

		<tr>
			<td width="50%">
				<form method="POST" action="/WebShowcase/authenServlet" id ="loginForm">
					<center>
						<table>
							<tr>
								<td>Username:</td>
								<td><input type="text" name="username" required /></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" required/></td>
							</tr>
							<tr>
								<td><input type="submit" value="Sign In" /></td>
							</tr>
						</table>
					</center>
				</form>
			</td>
		</tr>
	</table>
	
	<script>
		$( "#loginForm" ).validate();
	</script>
</body>
</html>