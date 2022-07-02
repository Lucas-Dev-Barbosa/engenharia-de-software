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
	  <h2>Cadastramento de Usuarios</h2>

		<form action="/usuario/incluir" method="post">
			<div class="mb-3 mt-3">
				<label>Acesso:</label>
				<select class="form-control" name="acesso">
					<c:forEach var="r" items="${roles}">
						<option value="${r.id}">${r.nome}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3 mt-3">
				<label>Nome:</label>
				<input type="text" class="form-control" name="nome">
			</div>
			
			<div class="mb-3 mt-3">
				<label>E-mail:</label>
				<input type="email" class="form-control" name="email">
			</div>
			
			<div class="mb-3 mt-3">
				<label>Senha:</label>
				<input type="password" class="form-control" name="senha">
			</div>
			
			<c:import url="/WEB-INF/jsp/endereco.jsp"/>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

</body>
</html>