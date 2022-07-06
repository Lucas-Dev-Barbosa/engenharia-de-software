<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
		<h2>Estabelecimentos</h2>

		<a href="/estabelecimentos?modo=listaCrua" class="btn btn-secondary">Lista de Estabelecimentos</a> 
		<a href="/estabelecimentos?modo=listaPorFuncionario" class="btn btn-secondary">Funcionários por estabelecimento</a>
		<security:authorize access="hasRole('ADMIN')">
			<a class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#cadastroEstabelecimentoModal">Incluir estabelecimento</a>
		</security:authorize>
		<hr>

		<c:if test="${not empty listaCrua}">
			<h4>Total de Estabelecimentos: ${listaCrua.size()}</h4>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>CNPJ</th>
						<th>Endereço</th>
						<th>EdTech</th>
						<security:authorize access="hasRole('ADMIN')">
				        	<th></th>
				        </security:authorize>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${listaCrua}">
						<tr>
							<td>${e.id}</td>
							<td>${e.nome}</td>
							<td>${e.cnpj}</td>
							<td>${e.endereco}</td>
							<td>
								<c:choose>
									<c:when test="${e.edTech}">
							           <input disabled checked class="form-check-input" type="checkbox" value="" name="edTech" id="edTech">
							        </c:when>
							        
							        <c:otherwise>
							           <input disabled class="form-check-input" type="checkbox" value="" name="edTech" id="edTech">
							        </c:otherwise>
								</c:choose>
							</td>
							<security:authorize access="hasRole('ADMIN')">
								<td><a href="/estabelecimentos/${e.id}/preExcluir">excluir</a></td>
							</security:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${not empty listaPorFuncionario}">
			<h4>Total de Estabelecimentos: ${listaPorFuncionario.size()}</h4>
			
			<c:forEach var="e" items="${listaPorFuncionario}">
				<div class="accordion accordion-flush" style="margin-top: 10px;" id="accordionFlushExample">
					<div class="accordion-item">
					   <h2 class="accordion-header" id="flush-headingOne">
					     <button class="accordion-button collapsed bg-light" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-${e.id}" aria-expanded="false" aria-controls="flush-collapseOne">
					       <p style="font-size: 20px;">${e.nome} - ${e.cnpj}</p>
					     </button>
					   </h2>
					   <div id="flush-collapse-${e.id}" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
					     <div class="accordion-body">
					     	<c:if test="${not empty e.funcionarios}">
						     	<table class="table table-striped">
									<thead>
										<tr>
											<th>ID</th>
											<th>Nome</th>
											<th>CPF</th>
											<th>E-mail</th>
											<th>Telefone</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="f" items="${e.funcionarios}">
											<tr>
												<td>${f.id}</td>
												<td>${f.nome}</td>
												<td>${f.cpf}</td>
												<td>${f.email}</td>
												<td>${f.telefone}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if>
							
							<c:if test="${empty e.funcionarios}">
								<p>Este estabelecimento não possui funcionários cadastrados</p>
							</c:if>
					     </div>
					   </div>
					 </div>
				</div>
			</c:forEach>
		</c:if>

		<c:if test="${empty listaCrua and empty listaPorFuncionario}">
			<p>É necessário selecionar uma das opções acima <b>ou</b> não existem estabelecimentos cadastrados!!</p>
		</c:if>

	</div>
	
	<div class="modal fade" id="cadastroEstabelecimentoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Cadastro de Estabelecimento</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <form class="row g-3" action="/estabelecimentos/incluir" method="post">
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
	          
	          <div class="col-12">
	            <label for="endereco" class="col-form-label">Endereço:</label>
	            <input type="text" class="form-control" name="endereco" id="endereco">
	          </div>
	          
	          <div class="col-md-6">
	            <label for="cnpj" class="col-form-label">CNPJ:</label>
	            <input type="text" class="form-control" name="cnpj" id="cnpj">
	          </div>
	          
	          <div class="col-md-6" style="margin-top: 60px;">
	            <input class="form-check-input" type="checkbox" name="edTech" id="edTech">
				<label class="form-check-label" for="edTech">
				  EdTech
				</label>
	          </div>
	          
	          <div class="mb-3 mt-3">
					<label>Acesso:</label>
					<select class="form-control" name="acesso">
						<c:forEach var="r" items="${roles}">
							<option value="${r.id}">${r.nome}</option>
						</c:forEach>
					</select>
				</div>
	          
	          <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
		        <button type="submit" class="btn btn-primary">Cadastrar</button>
		      </div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
	<c:if test="${not empty idEstabelecimentoExcluir}">
		<div class="modal fade" id="excluiEstabelecimentoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Excluir Estabelecimento</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		          <p>Realmente deseja excluir o estabelecimento?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
		        <a class="btn btn-primary" href="/estabelecimentos/${idEstabelecimentoExcluir}/excluir">Excluir</a>
		      </div>
		    </div>
		  </div>
		</div>
	</c:if>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript">
// 	Controlle do modal de exclusão do estabelecimento
	function controleModalExcluir(){
		var controleModal = document.getElementById('excluiEstabelecimentoModal');
		
		if(controleModal){
			const myModal = new bootstrap.Modal(controleModal);
			myModal.show();	
		}
	}
	controleModalExcluir();
</script>
</body>
</html>