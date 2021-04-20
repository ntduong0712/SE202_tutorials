<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%-- TO-DO: Include navigation bar (nav-bar.jsp)  --%>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<br>
	<%-- TO-DO: CREATE A FORM FOR UPDATING STUDENT --%>
	<form action="update" method="post">
		<div class="container">
			<h3 class="text-center">UPDATE STUDENT</h3>
			<fieldset class="form-group">
				<input type="hidden" class="form-control" name="id" value="<c:out value='${student.id}' />" />
				
				<label>Name</label>
				<input type="text" class="form-control" name="name" value="<c:out value='${student.name}' />"><br>
				
				<label>Department</label>
				<input type="text" class="form-control" name="department" value="<c:out value='${student.department}' />"><br>
				
				<label>Year</label>
				<input type="text" class="form-control" name="year" value="<c:out value='${student.year}' />"><br>
				
				<label>Address</label>
				<input type="text" class="form-control" name="address" value="<c:out value='${student.address}' />"><br>
				
				<label>Email</label>
				<input type="email" class="form-control" name="email" value="<c:out value='${student.email}' />"><br>
				
				<label>Phone</label>
				<input type="text" class="form-control" name="phone" value="<c:out value='${student.phone}' />">
			</fieldset>
			<button type="submit" class="btn btn-success">UPDATE</button>
		</div>
	</form>
</body>
</html>
