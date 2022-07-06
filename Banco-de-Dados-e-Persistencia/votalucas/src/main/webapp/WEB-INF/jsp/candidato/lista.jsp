<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppMIT</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Lista de Candidatos</h2>
	  
	  <security:authorize access="hasRole('ADMIN')">
		  <form action="/candidato" method="get">
		    <button type="submit" class="btn btn-primary">Novo</button>
		  </form>
	  </security:authorize>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Candidatos: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Número</th>
		        <th>Nome</th>
		        <th>Eleição</th>
		        <th>Votos</th>
		        <security:authorize access="hasRole('ADMIN')">
		        	<th></th>
		        </security:authorize>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="s" items="${lista}">
			      <tr>
			        <td>${s.id}</td>
			        <td>${s.numero}</td>
			        <td>${s.nome}</td>
			        <td>${s.eleicao.descricao}</td>
			        <td>${s.votos.size()}</td>
			        <security:authorize access="hasRole('ADMIN')">
			        	<td><a href="/candidato/${s.id}/excluir">excluir</a></td>
			        </security:authorize>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem candidatos cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>