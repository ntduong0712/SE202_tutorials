<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Include the JSTL Core library in JSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SE202-Tut04</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<br>
	<div class="container">
		<br>
		<h3 class="text-center">TEACHER LIST</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Address</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<%-- c:forEach => basic iteration tag --%>
				<c:forEach var="teacher" items="${listTeacher}">
					<tr>
						<%-- c:out => for expressions --%>
						<td><c:out value="${teacher.id}" /></td>
						<td><c:out value="${teacher.name}" /></td>
						<td><c:out value="${teacher.department}" /></td>
						<td><c:out value="${teacher.address}" /></td>
						<td><c:out value="${teacher.email}" /></td>
						<td><c:out value="${teacher.phone}" /></td>
						<td><a href="edit?id=<c:out value='${teacher.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${teacher.id}' />">Delete</a></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
