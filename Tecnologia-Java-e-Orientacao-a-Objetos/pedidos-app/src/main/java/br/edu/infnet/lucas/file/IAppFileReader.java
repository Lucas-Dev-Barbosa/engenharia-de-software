package br.edu.infnet.lucas.file;

import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import java.nio.file.Path;

public interface IAppFileReader<T> {

    T readFile(Path path, Class<T> classFromObject) throws PedidoException;

}
