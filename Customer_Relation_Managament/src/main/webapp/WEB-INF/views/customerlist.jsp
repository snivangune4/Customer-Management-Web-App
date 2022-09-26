<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Customers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
th, td {
	padding: 3px;
}

table, th, td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Customers Relationship Management</h1>
		<div>
			<form action="/Customer_Relation_Managament/customers/showform"
				method="Get">
				<a href="/Customer_Relation_Managament/customers/showform"><button>AddCustomer</button></a>
			</form>
		</div>
		<br>
		<div>
			<table class="table">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${customers }" var="customer">
					<tr>
						<td>${customer.first_Name }</td>
						<td>${customer.last_Name }</td>
						<td>${customer.email_Address }</td>
						<td><a
							href="/Customer_Relation_Managament/customers/edit/${customer.id }"><button>Update</button></a>
							<a
							href="/Customer_Relation_Managament/customers/delete/${customer.id }"><button
									onclick="myFunction()">Delete</button></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<p id="demo"></p>
			<script>
				function myFunction() {
					var txt;
					if (confirm("Do you want to delete this record!")) {
						txt = "Deleting!";
					}
					document.getElementById("demo").innerHTML = txt;
				}
			</script>
		</div>
	</div>
</body>
</html>