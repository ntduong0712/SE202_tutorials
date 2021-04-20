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
	<%-- TO-DO: CREATE A FORM FOR UPDATING COURSE --%>
	<form action="updateCourse" method="post">
		<div class="container">
			<h3 class="text-center">UPDATE COURSE</h3>
			<fieldset class="form-group">
				<input type="hidden" class="form-control" name="id" value="<c:out value='${course.id}' />" />
				
				<label>Name</label>
				<input type="text" class="form-control" name="name" value="<c:out value='${course.name}' />"><br>
				
				<label>Semester</label>
				<input type="text" class="form-control" name="semester" value="<c:out value='${course.semester}' />"><br>
				
				<label>Credit</label>
				<input type="text" class="form-control" name="credit" value="<c:out value='${course.credit}' />"><br>
				
				<label>Department</label>
				<input type="text" class="form-control" name="department" value="<c:out value='${course.department}' />">
			</fieldset>
			<button type="submit" class="btn btn-success">UPDATE</button>
		</div>
	</form>
</body>
</html>
