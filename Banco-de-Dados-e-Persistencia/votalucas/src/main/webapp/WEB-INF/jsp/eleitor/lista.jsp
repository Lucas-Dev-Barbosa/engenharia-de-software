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
	  <h2>Lista de Eleitores</h2>
	  
	  <security:authorize access="hasRole('ADMIN')">
		  <form action="/eleitor" method="get">
		    <button type="submit" class="btn btn-primary">Novo</button>
		  </form>
	  </security:authorize>
	  
	  <hr>
		
	<c:if test="${not empty lista}">		
		<h2>Total de Eleitores: ${lista.size()}</h2>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Código</th>
		        <th>Nome</th>
		        <th>E-mail</th>
		        <th>Telefone</th>
		        <th>Token</th>
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
			        <td>${s.codigo}</td>
			        <td>${s.nome}</td>
			        <td>${s.email}</td>
			        <td>${s.telefone}</td>
			        <td>${s.token}</td>
			        <td>${s.votos.size()}</td>
			        <security:authorize access="hasRole('ADMIN')">
			        	<td><a href="/eleitor/${s.id}/excluir">excluir</a></td>
			        </security:authorize>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem eleitores cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>