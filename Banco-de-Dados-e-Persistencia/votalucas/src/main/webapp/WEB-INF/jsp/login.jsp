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
	  <h2>Autenticação</h2>
	  
	  <form action="/login" method="post">
	    <div class="mb-3 mt-3">
		  <label>Login:</label>
		  <input type="text" class="form-control" name="username">
		</div>
		
		<div class="mb-3 mt-3">
		  <label>Senha:</label>
		  <input type="text" class="form-control" name="password">
		</div>

	    <button type="submit" class="btn btn-primary">Entrar</button>
	  </form>
	</div>
</body>
</html>