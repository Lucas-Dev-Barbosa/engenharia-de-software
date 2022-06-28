<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	  <h2>Votaew: gestão de votação</h2>
	</div>
	
	<div class="container mt-3">
	  <h3>${error} - Status: ${status}</h3>
	  <c:forEach var="m" items="${message}">
	  	<p>${m}</p>
	  </c:forEach>
	</div>
</body>
</html>