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
	  <h2>Lista de Municipios</h2>
	  
	  <c:if test="${not empty lista}">		
		<h4>Total de Municípios: ${lista.size()}</h4>
		  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="m" items="${lista}">
			      <tr>
			        <td>${m.id}</td>
			        <td>${m.nome}</td>
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h4>Não existem municípios cadastrados!!!</h4>
	</c:if>

	</div>
</body>
</html>