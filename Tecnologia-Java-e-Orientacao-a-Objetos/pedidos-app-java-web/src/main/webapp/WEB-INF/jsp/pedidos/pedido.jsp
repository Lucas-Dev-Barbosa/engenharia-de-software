<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Pedido</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
	
		<h4>Informações do pedido</h4>	
	
		<form action="/pedidos/salva" method="post">
		    <div class="input-group mb-3">
				<label class="input-group-text">Descrição:</label>
				<input type="text" class="form-control" value="${pedido.descricao}" name="descricao">
			</div>
			
			<div class="input-group mb-3">
				<label class="input-group-text">Data:</label>
				<input type="text" class="form-control" value="${pedido.data}" name="data">
			</div>
			
			<div class="input-group mb-3">
				<div class="input-group-text">
					<label class="form-check-label" for="web">Web:</label>
				</div>
				<div class="input-group-text">
					<input type="checkbox" class="form-check-input mt-0" value="${pedido.web}" name="web" id="web">
				</div>
			</div>
			
			<div class="input-group mb-3">
				<c:if test="${not empty solicitantes}">
					<label class="input-group-text">Solicitante:</label>
					
					<select id="solicitante" class="form-select" name="solicitante.id">
						<option selected="selected" disabled="disabled">Escolha	uma opção</option>
						<c:forEach var="s" items="${solicitantes}">
							<option value="${s.id}">${s.nome}</option>
						</c:forEach>
					</select>
				</c:if>

				<c:if test="${empty solicitantes}">
					<p>Não existem solicitantes cadastrados no momento!</p>
				</c:if>
			</div>
			
			<div class="input-group mb-3">
				<c:if test="${not empty produtos}">
					<label>Produtos:</label>
					<c:forEach var="p" items="${produtos}">
						<div class="input-group-text">
							<label class="form-check-label" for="web" title="${p.nome}"></label>
						</div>
						<div class="input-group-text">
							<input type="checkbox" class="form-check-input mt-0" value="${p.nome}" name="produto.id">
						</div>
					</c:forEach>
				</c:if>

				<c:if test="${empty produtos}">
					<p>Não existem produtos cadastrados no momento!</p>
				</c:if>
			</div>
			
			<br />

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>			  

	</div>
</body>
</html>