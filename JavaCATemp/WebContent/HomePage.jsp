<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="styles/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="styles/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">

<!-- Theme CSS -->
<link href="styles/css/grayscale.css" rel="stylesheet">
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation"
		style="background-color:#000000">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-main-collapse">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top"
				hover="font-size: 18px;"> <i class="fa fa-mortar-board animated"></i>
				<span class="light">CAPS</span> By Team 9
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div
			class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden"><a href="#page-top"></a></li>
				
				<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				
				<c:if test="${sessionScope.profile==null}">
				<li><a href="/WebShowcase/views/Login.jsp">Admin</a></li>
				<li><a href="/WebShowcase/views/Login.jsp">Lecturer</a></li>
				<li><a href="/WebShowcase/views/Login.jsp">Student</a></li>
				</c:if>
 				
				<c:if test="${sessionScope.role.equals('Admins')}"> 
 				<li><a href="/WebShowcase/loadData">MyPage</a></li> 
				
				</c:if> 
				
 				<c:if test="${sessionScope.role.equals('Students')}"> 
 				<li><a href="/WebShowcase/studentload">MyPage</a></li> 
 				</c:if>
				

				 
				<c:if test="${sessionScope.role.equals('Lectures')}">
				<li><a href="/WebShowcase/lecturer?value=coursesTaught">MyPage</a></li>
				</c:if>
				
				<li><a class="page-scroll" href="#about">About</a></li>
				<li><a class="page-scroll" href="#contact">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>

	<!-- Intro Header -->
	<header class="intro">
	<div class="intro-body">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<!-- <h1 class="brand-heading">Grayscale</h1> -->
					<h1>
						<img src="img/Logo(720x110).png"></img>
					</h1>
					<p class="intro-text" style="color: #505558;">
						Course Application Processing System <br>Presented by SA43
						Team 9
					</p>
					<a href="#about" class="btn btn-circle page-scroll"
						style="border: 2px solid #505558;"> <i
						class="glyphicon glyphicon-chevron-down animated"
						style="color: #505558;"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- About Section -->
	<section id="about" class="content-section text-center"
		style="background: url('img/issnus.jpg') no-repeat scroll">
	<div class="about-section">
		<div class="container">
			<div class="col-lg-8 col-lg-offset-2">
				<h1 style="color: white; opacity: 0.7;">WHO ARE WE</h1>
				<p style="color: white;">We are a pioneer in education and
					career transformation, specializing in today?s most in-demand
					skills. The leading source for training, staffing, and career
					transitions, we foster a flourishing community of professionals
					pursuing careers they love.</p>
				<p style="color: white;">As individuals and companies struggle
					to compete in an increasingly technological economy, we provide
					award-winning, dynamic training to close the global skills gap.</p>
				<a href="#contact" class="btn btn-circle page-scroll"
					style="border: 2px solid white;"> <i
					class="glyphicon glyphicon-chevron-down animated"
					style="color: white;"></i>
				</a>
			</div>
		</div>
	</div>
	</section>
	<!-- Contact Section -->
	<section id="contact" class="content-section text-center">
	<div class="contact-section">
		<div class="container">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>CONTACT US</h2>
				<p>Looking to get in touch? Feel free to contact any of the
					following addresses - based on the nature of your inquiry - and
					we'll get back to you soon.</p>
				<h3>Campus Information</h3>
				<p>
					<a href="mailto:nusisssa43@gmail.com" class="btn-mail"
						style="font-size: 20px;"> <i class="fa fa-envelope animated"></i>
						nusisssa43@gmail.com
					</a>
				</p>
				<h3>Phone Information</h3>
				<p>
					<i class="fa fa-phone-square"></i> +65 6789 1234 (General
					Enquiries)
				</p>
				<ul class="list-inline banner-social-buttons">
					<li><a href="https://facebook.com"
						class="btn btn-primary btn-lg"><i class="fa fa-facebook fa-fw"></i>
							<span class="network-name">Facebook</span></a></li>
					<li><a href="https://twitter.com" class="btn btn-info btn-lg"><i
							class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a></li>
					<li><a href="https://plus.google.com"
						class="btn btn-danger btn-lg"><i
							class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
					</li>
					<li><a href="#page-top" class="btn btn-circle page-scroll"
						style="border: 2px solid #505558; position: relative; left: 300px;">
							<i class="glyphicon glyphicon-chevron-up animated"
							style="color: #505558;"></i>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<footer>
	<div class="container text-center">
		<p style="color: #ffffff;">All Rights Reserved. &copy SA43 Team9,
			NUS, ISS 2016</p>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="styles/vendor/jquery/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="styles/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Theme JavaScript -->
	<script src="styles/js/grayscale.min.js"></script>

</body>
</html>