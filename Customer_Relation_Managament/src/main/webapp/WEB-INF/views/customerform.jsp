<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Customer Relationship Management</h1>
		<h3>Save Customer</h3>
		<form action="/Customer_Relation_Managament/customers/save"
			method="POST">
			<input type="hidden" name="id" value="${customer.id }" />
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">First
					Name</label> <input type="text" name="first_Name"
					value="${customer.first_Name }" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Last
					Name</label> <input type="text" name="last_Name"
					value="${customer.last_Name }" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Email</label>
				<input type="text" name="email_Address"
					value="${customer.email_Address }" class="form-control"
					id="exampleInputPassword1">
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form>
	</div>
</body>
</html>