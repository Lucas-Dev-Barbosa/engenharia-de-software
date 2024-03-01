package br.edu.infnet.lucas.model.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.lucas.model.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
