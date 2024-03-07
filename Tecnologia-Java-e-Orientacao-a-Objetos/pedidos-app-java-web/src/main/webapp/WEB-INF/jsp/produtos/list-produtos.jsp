<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Lista de Produtos</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
		<form action="/produtos/new" method="get">
		  <button type="submit" class="btn btn-primary">Novo</button>
		</form>
		
		<br>
		
		<c:if test="${not empty produtos}">		
			<h4>Total de Produtos: ${produtos.size()}</h4>
			  
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Nome</th>
			        <th>Valor</th>
			        <th>Código</th>
			        <th>Tipo</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="p" items="${produtos}">
				      <tr>
				        <td>${p.id}</td>
				        <td>${p.nome}</td>
				        <td>${p.valor}</td>
				        <td>${p.codigo}</td>
				        <td>${p.tipo}</td>
				        <td><a href="/produtos/${p.id}/delete">excluir</a></td>
				      </tr>
			      </c:forEach>		      
			    </tbody>
		  	</table>
	    </c:if>	  	  
	
		<c:if test="${empty produtos}">		
		  <h4>Não existem produtos cadastrados!</h4>
		</c:if>

	</div>
</body>
</html>