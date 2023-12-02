package br.edu.infnet.lucas.model.domain.vos;

import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cpf {

    private final String cpf;

    public Cpf(String cpf) throws CpfInvalidoException {
        ValidationVo.validaPadraoCpf(cpf);

        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cpf{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
