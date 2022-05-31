<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastramento de Eleitores</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Eleitores</h2>
	  
	  <form action="/eleitor/incluir" method="post">
	    <div class="mb-3 mt-3">
	      <label>Código:</label>
	      <input type="number" class="form-control" placeholder="Entre com o código" name="codigo" value="555">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="Lucas Barbosa">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="lucas.teste@teste.com">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Telefone:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu telefone" name="telefone" value="21654654654">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Token:</label>
	      <input type="text" class="form-control" placeholder="Entre com o token" name="token" value="xxxxxxxxxx">
	    </div>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>