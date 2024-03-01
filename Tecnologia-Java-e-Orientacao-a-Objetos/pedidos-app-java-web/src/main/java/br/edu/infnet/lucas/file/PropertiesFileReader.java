package br.edu.infnet.lucas.file;

import br.edu.infnet.lucas.model.domain.Pedido;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PropertiesFileReader {

    public Map<String, String> readPropertyFile(Path path) throws IOException {
        Map<String, String> fileLines = new HashMap<>();

        try(Stream<String> streamFile = Files.lines(path)) {
            streamFile.map(line -> line.split("="))
                    .forEach(splitLine -> fileLines.put(splitLine[0], splitLine[1]));
        }

        return fileLines;
    }

}
