<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppMIT</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Funcionários</h2>

		<a class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#cadastroFuncionarioModal">Incluir Funcionário</a>
		<hr>

		<c:if test="${not empty listaFuncionario}">
			<h4>Total de Funcionários: ${listaFuncionario.size()}</h4>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>Estabelecimento</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="f" items="${listaFuncionario}">
						<tr>
							<td>${f.id}</td>
							<td>${f.nome}</td>
							<td>${f.cpf}</td>
							<td>${f.email}</td>
							<td>${f.telefone}</td>
							<td>${f.estabelecimento.nome}</td>
							<td><a href="/funcionarios/${f.id}/preExcluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty listaFuncionario}">
			<p>Não existem funcionários cadastrados!!</p>
		</c:if>

	</div>
	
	<div class="modal fade" id="cadastroFuncionarioModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Cadastro de Funcionario</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <form class="row g-3" action="/funcionarios/incluir" method="post">
	          <div class="col-12">
	            <label for="nome" class="col-form-label">Nome:</label>
	            <input type="text" class="form-control" name="nome" id="nome">
	          </div>
	          
	          <div class="col-md-6">
	            <label for="login" class="col-form-label">Login:</label>
	            <input type="text" class="form-control" name="login" id="login">
	          </div>
	          
	          <div class="col-md-6">
	            <label for="senha" class="col-form-label">Senha:</label>
	            <input type="password" class="form-control" name="senha" id="senha">
	          </div>
	          
	          <div class="col-md-6">
	            <label for="cnpj" class="col-form-label">CPF:</label>
	            <input type="text" class="form-control" name="cpf" id="cnpj">
	          </div>
	          
	          <div class="col-md-6">
	            <label for="cnpj" class="col-form-label">Telefone:</label>
	            <input type="text" class="form-control" name="telefone" id="cnpj">
	          </div>
	          
	          <div class="col-12">
	            <label for="endereco" class="col-form-label">E-mail:</label>
	            <input type="text" class="form-control" name="email" id="endereco">
	          </div>
	          
	          <div class="col-12">
	            <label for="estabelecimentoSelect" class="col-form-label">Estabelecimento:</label>
	            <select id="estabelecimentoSelect" class="form-control" name="estabelecimento.id">
					<c:forEach var="e" items="${listaEstabelecimento}" >
						<option value="${e.id}">${e.nome}</option>
					</c:forEach>
				</select>
	          </div>
	          
	          <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
		        <button id="cadastrarFuncionario" type="submit" class="btn btn-primary">Cadastrar</button>
		      </div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
	<c:if test="${not empty idFuncionarioExcluir}">
		<div class="modal fade" id="excluiFuncionarioModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Excluir Estabelecimento</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		          <p>Realmente deseja excluir o funcionário?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
		        <a class="btn btn-primary" href="/estabelecimentos/${idFuncionarioExcluir}/excluir">Excluir</a>
		      </div>
		    </div>
		  </div>
		</div>
	</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript">
// 	Controlle do modal de exclusão do estabelecimento
	function controleModalExcluir(){
		var controleModal = document.getElementById('excluiFuncionarioModal');
		
		if(controleModal){
			const myModal = new bootstrap.Modal(controleModal);
			myModal.show();	
		}
	}
	controleModalExcluir();
	
	function validarSelectEstabelecimentos(){
		var select = document.getElementById('estabelecimentoSelect');
		var button = document.getElementById('cadastrarFuncionario');
		
		if(select.options.length == 0){
			button.disabled = true;
		}
	}
	
	validarSelectEstabelecimentos();
</script>
</body>
</html>