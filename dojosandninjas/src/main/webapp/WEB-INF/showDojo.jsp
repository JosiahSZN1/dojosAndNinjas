<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Dojo Page</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${dojo.name}"/> Ninjas</h1>
		<table class="table table-striped border border-3 border-secondary">
			<thead style="">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${dojo.ninjas}">
					<tr>
						<td><c:out value="${ninja.firstName}"/></td>
						<td><c:out value="${ninja.lastName}"/></td>
						<td><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>
			</tbody>		
		</table>
	</div>
</body>
</html>