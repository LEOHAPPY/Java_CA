<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td width="50%">
				<form method="POST" action="authenServlet">
					Username: <input type="text" name="username" /> <br />
					Password: <input
						type="text" name="password" /> <br /> 
							  <input type="submit"
						value="Sign In" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>