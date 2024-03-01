package br.edu.infnet.lucas.model.domain.vos;

import javax.persistence.Embeddable;

import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class Email {

    private final String emailAddress;

    public Email(String emailAddress) throws EmailInvalidoException {
        ValidationVo.validaPadraoEmail(emailAddress);

        this.emailAddress = emailAddress;
    }

}
