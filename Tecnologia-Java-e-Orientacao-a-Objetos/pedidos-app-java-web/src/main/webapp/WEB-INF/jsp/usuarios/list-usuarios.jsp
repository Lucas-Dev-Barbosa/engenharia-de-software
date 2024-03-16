<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
		<form action="/solicitantes/new" method="get">
		  <button type="submit" class="btn btn-primary">Novo</button>
		</form>
		
		<br>
		
		<c:if test="${not empty usuarios}">		
			<h4>Total de Usuários: ${usuarios.size()}</h4>
			  
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>Status</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="u" items="${usuarios}">
				      <tr>
				        <td>${s.id}</td>
				        <td>${s.nome}</td>
				        <td>${s.cpf.cpf}</td>
				        <td>${s.email.emailAddress}</td>
				        <td><a href="/solicitantes/${s.id}/delete">excluir</a></td>
				      </tr>
			      </c:forEach>		      
			    </tbody>
		  	</table>
	    </c:if>	  	  
	
		<c:if test="${empty usuarios}">		
		  <h4>Não existem usuários cadastrados!</h4>
		</c:if>

	</div>
</body>
</html>