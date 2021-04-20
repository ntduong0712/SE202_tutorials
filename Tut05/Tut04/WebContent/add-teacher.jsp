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
	<%-- TO-DO: CREATE A FORM FOR ADDING TEACHER --%>
	<form action="insert" method="post">
		<div class="container">
			<h3 class="text-center">ADD TEACHER</h3>
			<fieldset class="form-group">
				<label>Name</label>
				<input type="text" class="form-control" name="name" required="required"><br>
				
				<label>Department</label>
				<input type="text" class="form-control" name="department" required="required"><br>
				
				<label>Address</label>
				<input type="text" class="form-control" name="address" required="required"><br>
				
				<label>Email</label>
				<input type="text" class="form-control" name="email" required="required"><br>
				
				<label>Phone</label>
				<input type="text" class="form-control" name="phone" required="required">
			</fieldset>
			<button type="submit" class="btn btn-success">ADD</button>
		</div>
	</form>
	
</body>
</html>
