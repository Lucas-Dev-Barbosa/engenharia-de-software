<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastramento de Candidatos</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Candidatos</h2>
	  
	  <form action="/candidato/incluir" method="post">
	    <div class="mb-3 mt-3">
	      <label>Número:</label>
	      <input type="number" class="form-control" placeholder="Entre com o seu número" name="numero" value="555">
	    </div>
	    
	    <br/>
	    
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="Lucas Barbosa">
	    </div>
	    
	    <c:if test="${not empty eleicoes}">
			<label>Eleição:</label>
			<select class="form-control" name="eleicao.id">
				<option selected="selected" disabled="disabled">Escolha uma opção</option>
				<c:forEach var="e" items="${eleicoes}" >
					<option value="${e.id}">${e.descricao}</option>
				</c:forEach>
			</select>
		</c:if>
		
		<c:if test="${empty eleicoes}">
			<c:set var="botao" value="disabled" />
			<h5>Não existem eleições cadastradas no momento!!!</h5>
		</c:if>
		
		<br/>
	    
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>