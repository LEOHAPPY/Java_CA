<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
				<form method="POST" action="/WebShowcase/authenServlet">
					<center>
						<table>
							<tr>
								<td>Username:</td>
								<td><input type="text" name="username" /></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type="password" name="password" /></td>
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
</body>
</html>