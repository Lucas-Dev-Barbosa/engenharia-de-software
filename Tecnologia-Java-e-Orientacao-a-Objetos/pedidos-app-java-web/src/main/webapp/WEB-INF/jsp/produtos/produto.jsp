<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Produto</title>
</head>
<body>
	<c:import url="../template/header.jsp" />
	
	<div class="container mt-3">
	
		<h4>Informações do Produto</h4>	
	
		<form id="formProduto" method="post">
		    <div class="input-group mb-3">
				<label class="input-group-text">Nome:</label>
				<input type="text" class="form-control" value="${produto.nome}" name="nome">
			</div>
			
			<div class="input-group mb-3">
				<label class="input-group-text">Valor:</label>
				<input type="number" class="form-control" value="${produto.valor}" name="valor">
			</div>
			
			<div class="input-group mb-3">
				<label class="input-group-text">Código:</label>
				<input type="number" class="form-control" value="${produto.codigo}" name="codigo">
			</div>
			
			<div class="input-group mb-3">
				<label class="input-group-text">Tipo:</label>
				
				<select id="tipoProduto" class="form-select" name="tipo">
					<option selected="selected" disabled="disabled">Escolha	uma opção</option>
					<option value="b">Bebida</option>
					<option value="c">Comida</option>
					<option value="s">Sobremesa</option>
				</select>
			</div>
			
			<div id="tipo-produto-bebida" style="display: none">
				<div class="input-group mb-3" >
					<div class="input-group-text">
						<label class="form-check-label">Gelada:</label>
					</div>
					<div class="input-group-text">
						<input id="geladaCheck" type="checkbox" class="form-check-input mt-0" value="${produto.gelada}" name="gelada">
					</div>
				</div>
				
				<div class="input-group mb-3">
					<label class="input-group-text">Tamanho:</label>
					<input type="number" class="form-control" value="${produto.tamanho}" name="tamanho">
				</div>
				
				<div class="input-group mb-3">
					<label class="input-group-text">Marca:</label>
					<input type="text" class="form-control" value="${produto.marca}" name="marca">
				</div>
			</div>
			
			<div id="tipo-produto-comida" style="display: none">
				<div class="input-group mb-3">
					<label class="input-group-text">Peso:</label>
					<input type="number" class="form-control" value="${produto.peso}" name="peso">
				</div>
				
				<div class="input-group mb-3" >
					<div class="input-group-text">
						<label class="form-check-label">Vegano:</label>
					</div>
					<div class="input-group-text">
						<input id="veganoCheck" type="checkbox" class="form-check-input mt-0" value="${produto.vegano}" name="vegano">
					</div>
				</div>
				
				<div class="input-group mb-3">
					<label class="input-group-text">Ingredientes:</label>
					<input type="text" class="form-control" value="${produto.ingredientes}" name="ingredientes">
				</div>
			</div>
			
			<div id="tipo-produto-sobremesa" style="display: none">
				<div class="input-group mb-3">
					<label class="input-group-text">Quantidade:</label>
					<input type="number" class="form-control" value="${produto.quantidade}" name="quantidade">
				</div>
				
				<div class="input-group mb-3" >
					<div class="input-group-text">
						<label class="form-check-label">Doce:</label>
					</div>
					<div class="input-group-text">
						<input id="doceCheck" type="checkbox" class="form-check-input mt-0" value="${produto.doce}" name="doce">
					</div>
				</div>
				
				<div class="input-group mb-3">
					<label class="input-group-text">Informação:</label>
					<input type="text" class="form-control" value="${produto.informacao}" name="informacao">
				</div>
			</div>
			
			<br />

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>			  

	</div>
	
	<script type="text/javascript">
		var selectElement = document.getElementById("tipoProduto");
		var formElement = document.getElementById("formProduto");
		
		selectElement.addEventListener('change', function(){
			
			var basePath = "/produtos";
		    switch(selectElement.value) {
		    case 'b':
		    	formElement.action = basePath + "/bebida/salva";
		    	break;
		    case 'c':
		    	formElement.action = basePath + "/comida/salva";
		    	break;
		    case 's':
		    	formElement.action = basePath + "/sobremesa/salva";
		    	break;
	    	}
			
			document.querySelectorAll("[id^='tipo-produto-']").forEach((e) => { e.style.display = "none"; });
			
		    switch(selectElement.value) {
			    case 'b':
			    	document.getElementById("tipo-produto-bebida").style.display = "block";
			    	break;
			    case 'c':
			    	document.getElementById("tipo-produto-comida").style.display = "block";
			    	break;
			    case 's':
			    	document.getElementById("tipo-produto-sobremesa").style.display = "block";
			    	break;
		    }
		    
		});
		
		var geladaCheck = document.getElementById("geladaCheck");
		
		geladaCheck.addEventListener('change', function(){
			geladaCheck.value = geladaCheck.checked;
		});
		
		var veganoCheck = document.getElementById("veganoCheck");
		
		veganoCheck.addEventListener('change', function(){
			veganoCheck.value = veganoCheck.checked;
		});
		
		var doceCheck = document.getElementById("doceCheck");
		
		doceCheck.addEventListener('change', function(){
			doceCheck.value = doceCheck.checked;
		});
	</script>
</body>
</html>