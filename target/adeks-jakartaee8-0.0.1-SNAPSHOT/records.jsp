<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import Google Icon Font-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<title>Student Record</title>
</head>
<body>
	<nav class="text green darken-4">
		<div class="nav-wrapper container ">
			<a id="logo-container" href="#" class="brand-logo">Registration</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="test.html">New Form</a></li>
				<li><a href="find?id=all">Record</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<br />
	<br />
	<div class="container">
		<h2 class="green-text text-darken-4">Student Record</h2>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Surname</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Email</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.firstName}</td>
					<td>${student.middleName }</td>
					<td>${student.surName}</td>
					<td>${student.address}</td>
					<td>${student.phone}</td>
					<td>${student.email}</td>
					<td><a href="find?id=${student.id}"><i class="small material-icons green-icon">create</i></a></td>
					<td><a href="delete?id=${student.id}"><i class="small material-icons">delete_forever</i></a></td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	<br />
	<br />
	<br />
	<br />

</body>
</html>