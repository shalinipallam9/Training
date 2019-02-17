<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Contact Manager Home</title>
</head>

<body>
	<div>
		<nav class="navbar navbar-expand-sm bg-light"> <!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Link 1</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link 2</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link 3</a></li>
		</ul>

		</nav>

	</div>
	<div class="mt-5 ml-5 mr-5">
		<div class="container">
				<div class="col-sm-8">
				<div class="d-flex align-items-center">...</div>
				<h1>Contact List</h1>
			</div>
			<h3>
				<div class="row>">
					<div class="col-4"></div>
					<div class="float-mid">
						<p>
							<a href="newContact" class="text-primary">New Contact</a>
						</p>
					</div>
				</div>
			</h3>
		</div>
		<div class="container">

			<table class="table table-dark table-striped">
				<thead class="thead-dark">
					<tr>
						<th>No</th>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Telephone</th>
						<th>Action</th>
					</tr>
				</thead>
				</div>
				</div>
				<div class="mt-5 ml-5 mr-5">
					<c:forEach var="contact" items="${listContact}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${contact.name}</td>
							<td>${contact.email}</td>
							<td>${contact.address}</td>
							<td>${contact.telephone}</td>
							<td><a href="editContact?id=${contact.id}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteContact?id=${contact.id}">Delete</a></td>

						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>