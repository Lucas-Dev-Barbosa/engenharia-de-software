<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppMIT</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Lista de Votos</h2>

		<security:authorize access="hasRole('ADMIN')">
			<form id="form" action="/voto" method="post">
				<div class="form-group">
					<c:if test="${not empty eleicoes}">
						<label>Para cadastrar um novo voto, selecione a eleição:</label>
						<select id="eleicoes" class="form-control" name="eleicao.id" onchange="validaSelectEleicoes()">
							<option>Escolha uma opção</option>
							<c:forEach var="e" items="${eleicoes}" >
								<option value="${e.id}">${e.descricao}</option>
							</c:forEach>
						</select>
						
						<br />
						
						<button id="botao" type="submit" class="btn btn-primary">Novo</button>
					</c:if>
	
					<c:if test="${empty eleicoes}">
						<c:set var="botao" value="disabled" />
						<h5>Não existem eleições cadastradas!!!</h5>
						<h5>Cadastre eleições para cadastrar novos votos.</h5>
					</c:if>
				</div>
			</form>
		</security:authorize>

		<hr>

		<c:if test="${not empty lista}">
			<h2>Total de Votos: ${lista.size()}</h2>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Data</th>
						<th>Localização</th>
						<th>Eleitor</th>
						<th>Eleição</th>
						<th>Candidato</th>
						<security:authorize access="hasRole('ADMIN')">
				        	<th></th>
				        </security:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" items="${lista}">
						<tr>
							<td>${s.id}</td>
							<td>${s.data}</td>
							<td>${s.localizacao}</td>
							<td>${s.eleitor.nome}</td>
							<td>${s.eleicao.descricao}</td>
							<td>${s.candidato.nome}</td>
							<security:authorize access="hasRole('ADMIN')">
								<td><a href="/voto/${s.id}/excluir">excluir</a></td>
							</security:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h2>Não existem votos cadastrados!!!</h2>
		</c:if>

	</div>
	
<script type="text/javascript">
	validaSelectEleicoes();
	
	function validaSelectEleicoes(){
		var select = document.getElementById('eleicoes');
		var value = select.options[select.selectedIndex].value;
		
		if(value === 'Escolha uma opção'){
			document.getElementById('botao').disabled = true;
		} else {
			document.getElementById('botao').disabled = false;
		}
	}
</script>
</body>
</html>