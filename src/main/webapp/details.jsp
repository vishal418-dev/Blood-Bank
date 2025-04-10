<%@page import="java.util.ArrayList"%>
<%@page import="com.infoviaan.dto.Donor"%>
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
	<%
	ArrayList<Donor> al = (ArrayList<Donor>) request.getAttribute("LIST");
	String ms = (String) request.getAttribute("msg");
	%>
	<div class="container">
		<div class="jumbotron">
			<h1>Donors Details</h1>
			<%
			if (ms != null) {
				out.print("<h2>" + ms + "</h2>");
			}
			%>
		</div>

		<table class="table" border="1">
			<thead class="thead thead-dark">
				<th>NAME</th>
				<th>AGE</th>
				<th>BLOOD GROUP</th>
				<th>DISEAS</th>
				<th>GENDER</th>
				<th>MOBILE</th>
				<th>DELETION</th>
				<th>EDIT</th>
			</thead>

			<%
			for (Donor ds : al) {
			%>
			<tr>
				<td><%=ds.getName()%></td>
				<td><%=ds.getAge()%></td>
				<td><%=ds.getBloodgroup()%></td>
				<td><%=ds.isDiseas()%></td>
				<td><%=ds.getGender()%></td>
				<td><%=ds.getMobile()%></td>
				<td><a href="DeleteCtrl?mobile=<%=ds.getMobile()%>"
					class="btn btn-danger" onclick="return confirm('Are you sure to delete this record?')"> DELETE </a></td>
				<td><a href="UpdateController?mobile=<%=ds.getMobile()%>" class="btn btn-primary">EDIT</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>