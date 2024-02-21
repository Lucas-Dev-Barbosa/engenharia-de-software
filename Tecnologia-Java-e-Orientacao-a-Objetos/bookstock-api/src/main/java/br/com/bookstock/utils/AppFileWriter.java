package br.com.bookstock.utils;

import java.io.IOException;
import java.nio.file.Path;

public interface AppFileWriter<T> {

    void writeFile(Path path, T contentFile) throws IOException;
	
}
