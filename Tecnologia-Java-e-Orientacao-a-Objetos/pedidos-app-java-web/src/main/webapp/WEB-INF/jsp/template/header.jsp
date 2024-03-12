<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url value="/" />">APP</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<c:url value="/" />">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/pedidos/lista" />">Pedidos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/solicitantes/lista" />">Solicitantes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/produtos/lista" />">Produtos</a>
        </li>
      </ul>
      <span class="navbar-text">
        App para gerenciamento de pedidos
      </span>
    </div>
  </div>
</nav>