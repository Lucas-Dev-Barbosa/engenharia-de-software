package br.com.bookstock.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AppFileWriterCsv implements AppFileWriter<List<List<String>>> {

    @Override
    public void writeFile(Path path, List<List<String>> fileLines) throws IOException {
        BufferedWriter bufferedWriter = getWriter(path);
        fileLines
            .forEach(linha -> {
                escreveLinhaNoArquivoCsv(path, montaLinhaCsv(linha), bufferedWriter);
            });
        closeWriter(bufferedWriter);
    }

    private BufferedWriter getWriter(Path path) throws IOException {
        File file = new File(path.toUri());
        return new BufferedWriter(new FileWriter(file));
    }

    private void escreveLinhaNoArquivoCsv(Path path, String linha, BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write(linha);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void closeWriter(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private String montaLinhaCsv(List<String> linha) {
        return linha
            .stream()
            .reduce("", (partialValue, element) -> partialValue + ";" + element)
            .substring(1);
    }
}
