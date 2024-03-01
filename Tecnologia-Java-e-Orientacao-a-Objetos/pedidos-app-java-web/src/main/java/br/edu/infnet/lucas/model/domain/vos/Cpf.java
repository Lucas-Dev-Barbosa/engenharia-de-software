package br.edu.infnet.lucas.model.domain.vos;

import javax.persistence.Embeddable;

import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class Cpf {

    private final String cpf;

    public Cpf(String cpf) throws CpfInvalidoException {
        ValidationVo.validaPadraoCpf(cpf);

        this.cpf = cpf;
    }
    
}
