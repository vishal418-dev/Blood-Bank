<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="adminHeader.jsp"%>
<body>
	<div class="container">
		<h2>Donor Registration</h2>
		<%
		String ms = (String) request.getAttribute("msg");
		if (ms != null)
			out.print("<h2 style='color:blue;'>" + ms + "</h2>");
		%>
		<form action="registerController" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">NAME</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">AGE</label> <input type="numeric"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="age">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">BLOOD GROUP</label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="bloodgroup">
			</div>
			DESEAS :
			<div class="form-check">
				<input class="form-check-input" type="radio" name="diseas"
					id="exampleRadios1" value="YES"> <label
					class="form-check-label" for="exampleRadios1"> YES </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="diseas"
					id="exampleRadios2" value="NO"> <label
					class="form-check-label" for="exampleRadios2"> NO </label>
			</div>
			<br> GENDER :
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="exampleRadios1" value="male"> <label
					class="form-check-label" for="exampleRadios1"> MALE </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="exampleRadios2" value="female"> <label
					class="form-check-label" for="exampleRadios2"> FEMALE </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender"
					id="exampleRadios2" value="transgender"> <label
					class="form-check-label" for="exampleRadios2"> TRANSGENDER
				</label>
			</div>
			<br>
			<div class="form-group">
				<label for="exampleInputEmail1">MOBILE</label> <input type="numeric"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="mobile">
			</div>
			<button type="submit" class="btn btn-primary">REGISTER</button>
		</form>
	</div>
</body>
</html>