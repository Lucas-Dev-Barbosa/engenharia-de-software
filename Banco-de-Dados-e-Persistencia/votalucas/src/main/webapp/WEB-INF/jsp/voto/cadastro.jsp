<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastramento de Votos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastramento de Votos</h2>

		<form action="/voto/incluir" method="post">
			<div class="form-group">
				<label>Eleição:</label> <input type="text" disabled="disabled"
					class="form-control" value="${eleicao.descricao}"> <input
					type="hidden" class="form-control" name="eleicao.id"
					value="${eleicao.id}"> <br />

				<c:if test="${not empty eleitores}">
					<label>Eleitor:</label>
					<select id="eleitor" class="form-control" name="eleitor.id">
						<c:forEach var="e" items="${eleitores}">
							<option value="${e.id}">${e.nome}</option>
						</c:forEach>
					</select>
				</c:if>

				<c:if test="${empty eleitores}">
					<c:set var="botao" value="disabled" />
					<label>Não existem eleitores cadastrados nesta eleição!!!</label>
				</c:if>

				<br />

				<c:if test="${not empty eleicao.candidatos}">
					<label>Candidatos:</label>
					<select id="candidato" class="form-control" name="candidato.id">
						<c:forEach var="c" items="${eleicao.candidatos}">
							<option value="${c.id}">${c.nome}</option>
						</c:forEach>
					</select>
				</c:if>

				<c:if test="${empty eleicao.candidatos}">
					<c:set var="botao" value="disabled" />
					<label>Não existem candidatos cadastrados para esta
						eleição!!!</label>
				</c:if>
			</div>

			<br />

			<div class="mb-3 mt-3">
				<label>Localização:</label> <input type="text" class="form-control"
					placeholder="Entre com a localização" name="localizacao"
					value="Local">
			</div>

			<br />

			<button id="botao" type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

<script type="text/javascript">
    validaCadastro();
	
	function validaCadastro(){
		var eleitor = document.getElementById('eleitor');
		var candidato = document.getElementById('candidato');
		
		if(!eleitor || !candidato){
			document.getElementById('botao').disabled = true;
		}
	}
</script>
</body>
</html>