<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#wrap {
	width: 1050px;
}
.first {
	float: left;
	width: 220px;
	height: 620px;
	padding: 10px;
	margin-left: 20px;
	margin-right: 10px;
}
.second {
	float: left;
	width: 350px;
	margin-left: 10px;
	margin-right: 10px;
}
.third {
	float: left;
	width: 400px;
	margin-left: 10px;
	height: 445px;
}
p {
	text-align: justify;
	text-justify: inter-word;
}
</style>
<title>Home Page</title>
</head>
<body>
	<div id="wrap">
		<!-- <div class="first" style="background-image:url('../Image/University.png')"> -->
		<div class="first">
			<img src="${pageContext.request.contextPath }/img/Banner1.png" alt="Banner1"
				style="width: 220px; height: 620px;"></img>
		</div>
		<div class="second">
			<h1>WHO ARE WE</h1>
			<p>We are a pioneer in education and career transformation,
				specializing in today?s most in-demand skills. The leading source
				for training, staffing, and career transitions, we foster a
				flourishing community of professionals pursuing careers they love.
				As individuals and companies struggle to compete in an increasingly
				technological economy, we provide award-winning, dynamic training to
				close the global skills gap.</p>
			<img src="${pageContext.request.contextPath }/img/Banner2.png" alt="Banner2"
				style="width: 100%;"></img>
		</div>
		<div class="third">
			<h1>CONTACT US</h1>
			<p>Looking to get in touch? Feel free to contact any of the
				following addresses - based on the nature of your inquiry - and
				we'll get back to you soon.</p>
			<h1>Campus Information</h1>
			<a href="google.com">nusisssa43@gmail.com</a>
			<h1>Phone Information</h1>
			<p>+65 6789 1234 (General Enquiries)</p>
		</div>
	</div>
</body>
</html>