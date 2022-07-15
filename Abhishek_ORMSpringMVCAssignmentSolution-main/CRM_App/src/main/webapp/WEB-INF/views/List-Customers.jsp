<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customers Directory</title>
</head>

<body>
	<div class="container">
		<h3>CUSTOMER RELATIONSHIP MANAGEMENT</h3>
		<hr>
		<div>
			<a href="/CRM_App/operations/addCustomer"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a>
		</div>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customer}" var="customer">
					<tr>
						<td><c:out value="${customer.firstName}" /></td>
						<td><c:out value="${customer.lastName}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/CRM_App/operations/update?customerId=${customer.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/CRM_App/operations/delete?customerId=${customer.id}"
							class="btn btn-danger btn-sm ml-2"
							onclick="if (!(confirm('Are you sure you want to delete?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
	</div>
</body>
</html>
