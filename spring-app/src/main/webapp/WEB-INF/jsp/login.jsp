<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Spring Login Form</title>
</head>
<body>

<!-- Grey with black text -->
	<div>
		<div>
			<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Active</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
				</li>
			</ul>
			</nav>

			<!-- Black with white text -->
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">...</nav>
		</div>
		<div>
			<form:form name="submitForm" method="POST" action="procesLogin">
				<div class="row">
					<div class="col-3"></div>
					<div class="col-6">
						<div class="form-group">
							<label for="userName">User Name:</label> <input type="text"
								class="form-control" id="userName" name="userName">
						</div>


						<div class="form-group">
							<label for="password">Password:</label> <input type="password"
								class="form-control" name="password" id="password">
						</div>

						<input type="submit" class="btn btn-primary float-right" value="Submit" />


						<p class="text-danger">Login failed : <strong class="text-info">${msg}</strong></p>
					</div>
				</div>
				<div class="col-3"></div>
			</form:form>
		</div>
	</div>
</body>
</html>