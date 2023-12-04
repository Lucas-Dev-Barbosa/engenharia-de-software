package br.edu.infnet.lucas.model.domain.repository;

import br.edu.infnet.lucas.file.IAppFileReader;
import br.edu.infnet.lucas.model.domain.Pedido;
import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class PedidoRepository extends AbstractRepository<Pedido>{

    @Autowired
    private IAppFileReader<Pedido> appFileReader;

    @PostConstruct
    public void leArquivoDeDados() throws IOException, EmailInvalidoException, CpfInvalidoException, PedidoException {
        Pedido pedido = appFileReader
                .readFile(Paths.get(".", "/src/main/resources/pedidos.json"), Pedido.class);

        insert(pedido);
    }

}
