<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Lista de Pedidos</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
		<form action="/pedidos/new" method="get">
		  <button type="submit" class="btn btn-primary">Novo</button>
		</form>
		
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
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="p" items="${pedidos}">
				      <tr>
				        <td>${e.id}</td>
				        <td>${e.descricao}</td>
				        <td>${e.data}</td>
				        <td>${e.web}</td>
				        <td>${e.solicitante.nome}</td>
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