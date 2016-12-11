<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- left navigation -->
	<table style="float: left">
		<td><%@ include file="SamePart.jsp"%></td>
	</table>

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

	<table class="borderAll"  border="1px" >
		<tr>
			<th>#</th>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit  Delete</th>
		</tr>

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
	<table border="1" cellpadding="5" cellspacing="5" align=center>
		<tr>
			<%--For displaying Previous link except for the 1st page --%>
			<c:if test="${currentPage != 1}">
				<td><a href="loadData?page=${currentPage - 1}">Previous</a></td>
			</c:if>

			<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>


			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>

					<c:otherwise>
						<c:choose>
							<c:when test="${i eq 2}">
								<td><a href="../loadData?page=${i}">${i}</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="loadData?page=${i}">${i}</a></td>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:forEach>


			<%--For displaying Next link --%>
			<c:if test="${currentPage lt noOfPages}">
				<td><a href="loadData?page=${currentPage + 1}">Next</a></td>
			</c:if>
		</tr>
	</table>
</body>
</html>