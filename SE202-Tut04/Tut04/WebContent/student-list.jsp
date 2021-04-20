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
	<div class="container">
		<br>
		<h3 class="text-center">STUDENT LIST</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Department</th>
					<th>Year</th>
					<th>Address</th>
					<th>Email</th>
					<th>Phone</th>
				</tr>
			</thead>
			<tbody>
				<%-- c:forEach => basic iteration tag --%>
				<c:forEach var="student" items="${listStudent}">
					<tr>
						<%-- c:out => for expressions --%>
						<td><c:out value="${student.id}" /></td>
						<td><c:out value="${student.name}" /></td>
						<td><c:out value="${student.department}" /></td>
						<td><c:out value="${student.year}" /></td>
						<td><c:out value="${student.address}" /></td>
						<td><c:out value="${student.email}" /></td>
						<td><c:out value="${student.phone}" /></td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
