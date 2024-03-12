<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Lista de Pedidos</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
		<form action="/pedidos/new" method="get">
		  <button type="submit" class="btn btn-primary">Novo</button>
		</form>
		
		<br>
		
		<c:if test="${not empty pedidos}">		
			<h4>Total de Pedidos: ${pedidos.size()}</h4>
			  
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Descrição</th>
			        <th>Data</th>
			        <th>Web</th>
			        <th>Solicitante</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="p" items="${pedidos}">
				      <tr>
				        <td>${p.id}</td>
				        <td>${p.descricao}</td>
				        <td>${p.data}</td>
				        <td>${p.web}</td>
				        <td>${p.solicitante.nome}</td>
				        <td><a href="/pedidos/${p.id}/delete">excluir</a></td>
				      </tr>
			      </c:forEach>		      
			    </tbody>
		  	</table>
	    </c:if>	  	  
	
		<c:if test="${empty pedidos}">		
		  <h4>Não existem pedidos cadastrados!</h4>
		</c:if>

	</div>
</body>
</html>