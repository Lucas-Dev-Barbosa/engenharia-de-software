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
	
		<h4>Informações do pedido</h4>	
	
		<form action="/pedidos/salva" method="post">
		    <div class="mb-3 mt-3">
				<label>Descrição:</label>
				<input type="text" class="form-control" value="${pedido.descricao}" name="descricao">
			</div>
			
			<br />
			
			<div class="mb-3 mt-3">
				<label>Data:</label>
				<input type="text" class="form-control" value="${pedido.data}" name="data">
			</div>
			
			<br />
			
			<div class="form-check">
				<label class="form-check-label" for="web">Web:</label>
				<input type="checkbox" class="form-check-input" value="${pedido.web}" name="web" id="web">
			</div>
			
			<br />

			<div class="mb-3 mt-3">
				<c:if test="${not empty solicitantes}">
					<label>solicitante:</label>
					<select id="solicitante" class="form-control" name="solicitante.id">
						<option selected="selected" disabled="disabled">Escolha	uma opção</option>
						<c:forEach var="s" items="${solicitantes}">
							<option value="${s.id}">${s.nome}</option>
						</c:forEach>
					</select>
				</c:if>

				<c:if test="${empty solicitantes}">
					<h5>Não existem solicitantes cadastrados no momento!</h5>
				</c:if>
			</div>
			
			<br />
			
			<div class="mb-3 mt-3">
				<c:if test="${not empty produtos}">
					<label>Produtos:</label>
					<c:forEach var="p" items="${produtos}">
						<input type="checkbox" class="form-check-input" value="${p.nome}" name="produto.id">
					</c:forEach>

				</c:if>

				<c:if test="${empty produtos}">
					<h5>Não existem produtos cadastrados no momento!</h5>
				</c:if>
			</div>
			
			<br />

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>			  

	</div>
</body>
</html>