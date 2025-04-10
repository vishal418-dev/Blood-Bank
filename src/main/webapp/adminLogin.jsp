<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="frontHeader.jsp"%>
<body>
	<div class="container">
		<h1>Admin Login</h1>

		<%
		String mm = (String) request.getAttribute("msg");
		if (mm != null)
			out.print("<h2 style='color:red;'>" + mm + "</h2>");
		%>

		<form action="loginCheck" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">USER NAME</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="uname">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					name="pwd">
			</div>
			<button type="submit" class="btn btn-primary">LOGIN</button>
		</form>
	</div>

</body>
</html>