<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Login User</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
	
		<h4>LOGIN</h4>	
	
		<form action="/auth/login" method="post">
		    <div class="input-group mb-3">
				<label class="input-group-text">E-mail:</label>
				<input type="text" class="form-control" value="${usuario.email}" name="email">
			</div>
			
			<div class="input-group mb-3">
				<label class="input-group-text">Password:</label>
				<input type="text" class="form-control" value="${usuario.password}" name="email">
			</div>
			
			<br />

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>			  

	</div>
</body>
</html>