<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<!-- add -->

	<!-- add -->
	<c:url var="url" scope="page" value="/views/Admin/SetUpPage.jsp">
		<c:param name="id" value="" />
		<c:param name="name" value="" />
		<c:param name="email" value="" />
		<c:param name="pw" value="" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${url}">Add</a>
	<br />
	<br />

	<table class="table" >
  <thead class="thead-inverse">
		<tr>
			<th>#</th>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit  Delete</th>
		</tr>
</thead>
		<c:forEach var="person" items="${requestScope.person}"
				varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                    <td class="nowrap">${status.index + 1}</td>
                    <td class="nowrap">${person.id}</td>
                    <td class="nowrap">${person.name}</td>
                    <td class="nowrap">${person.email}</td>
                    <td class="nowrap">${person.pw}</td>
                    
                    <!-- Edit -->
                    <td class="nowrap">
                        <c:url var="updurl" scope="page"
							value="/views/Admin/SetUpPage.jsp">
                            <c:param name="id" value="${person.id}" />
                            <c:param name="name" value="${person.name}" />
                            <c:param name="email"
								value="${person.email}" />
                            <c:param name="pw" value="${person.pw}" />
                            <c:param name="update" value="false" />
                        </c:url>
                        <a href="${updurl}">Edit</a>

                        &nbsp;&nbsp;&nbsp;&nbsp
                       <c:if test="${sessionScope.iddd ne person.id}">
                        <!-- Delete -->
	                        <c:url var="delurl" scope="page"
								value="/deleteProcess">
	                            <c:param name="id" value="${person.id}" />
	                        </c:url>
	                        <a href="${delurl}">Delete</a>
                       </c:if> 
                    </td>
                </tr>
            </c:forEach>
	</table>
	<center>
	
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<c:if test="${currentPage != 1}">
				<li class="page-item active"><a class="page-link"
					href="${pageContext.request.contextPath}/loadData?page=${currentPage - 1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
				</a></li>
			</c:if>
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<li class="page-item active"><a class="page-link"
							href="${pageContext.request.contextPath}/loadData?page=${i}">${i}<span class="sr-only">(current)</span></a></li>
					</c:when>
					<c:otherwise>

<%-- 						<c:choose> --%>
<%-- 							<c:when test="${i eq 2}"> --%>
<!-- 								<li class="page-item"><a class="page-link" -->
<%-- 									href="${pageContext.request.ContextPath}/loadData?page=${i}">${i}<span class="sr-only">(current)</span></a></li> --%>
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> --%>
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/loadData?page=${i}">${i}<span class="sr-only">(current)</span></a></li>
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose> --%>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${currentPage lt noOfPages}">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/loadData?page=${currentPage + 1}" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
				</a></li>
			</c:if>
		</ul>
	</nav>
</center>




</div>

</div>
</body>
</html>