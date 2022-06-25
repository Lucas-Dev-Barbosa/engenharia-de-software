<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>App Endereço</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Lista de Estados</h2>
	  
	  <c:if test="${not empty lista}">		
		<h4>Total de Estados: ${lista.size()}</h4>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Sigla</th>
		        <th>Nome</th>
		        <th>Região</th>
		        <th>Municípios</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="e" items="${lista}">
			      <tr>
			        <td>${e.id}</td>
			        <td>${e.sigla}</td>
			        <td>${e.nome}</td>
			        <td>${e.regiao.nome}</td>
			        <td><a href="/${e.id}/municipios">Municípios de ${e.sigla}</a></td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h4>Não existem estados cadastrados!!!</h4>
	</c:if>

	</div>
</body>
</html>