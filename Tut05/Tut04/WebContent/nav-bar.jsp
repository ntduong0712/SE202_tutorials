<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%-- TO-DO: CREATE A NAVIGATION BAR WHICH INCLUDES HYPERLINK TO ADD & VIEW FORM --%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>">HOME</a></li>
				<li><a href="<%=request.getContextPath()%>/Student">STUDENT LIST</a></li>
				<li><a href="<%=request.getContextPath()%>/insertStudent">ADD STUDENT</a></li>
				<li><a href="<%=request.getContextPath()%>/Teacher">TEACHER LIST</a></li>
				<li><a href="<%=request.getContextPath()%>/insertTeacher">ADD TEACHER</a></li>
				<li><a href="<%=request.getContextPath()%>/Course">COURSE LIST</a></li>
				<li><a href="<%=request.getContextPath()%>/insertCourse">ADD COURSE</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>