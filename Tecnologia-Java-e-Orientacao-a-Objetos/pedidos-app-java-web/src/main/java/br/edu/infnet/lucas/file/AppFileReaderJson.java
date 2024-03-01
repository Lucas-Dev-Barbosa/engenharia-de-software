package br.edu.infnet.lucas.file;

import br.edu.infnet.lucas.model.domain.exception.PedidoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public class AppFileReaderJson<T> implements IAppFileReader<T> {

    @Override
    public T readFile(Path path, Class<T> classFromObject) throws PedidoException {

        try {
           return getObjectMapper().readValue(getJsonTextFromFile(path), classFromObject);
        } catch (PedidoException | IOException e) {
            throw new PedidoException(e.getMessage());
        }
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }

    private String getJsonTextFromFile(Path path) throws IOException, PedidoException {
        String jsonText;
        try(Stream<String> fileLine = Files.lines(path)) {
            jsonText = fileLine.reduce((txt1, txt2) -> txt1 + txt2).orElseThrow(() -> new PedidoException("Nao foi possivel ler o json do arquivo"));
        }

        return jsonText;
    }
}
