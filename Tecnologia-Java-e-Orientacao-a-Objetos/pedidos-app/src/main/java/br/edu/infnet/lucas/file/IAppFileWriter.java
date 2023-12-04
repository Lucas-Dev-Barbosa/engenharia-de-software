package br.edu.infnet.lucas.file;

import java.io.IOException;
import java.nio.file.Path;

public interface IAppFileWriter<T> {

    void writeFile(Path path, T contentFile) throws IOException;

}
