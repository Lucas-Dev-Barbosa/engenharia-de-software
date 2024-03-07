package br.edu.infnet.lucas.model.domain.vos;

import javax.persistence.Embeddable;

import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@Embeddable
public class Email {

    private String emailAddress;

    public Email(String emailAddress) throws EmailInvalidoException {
        ValidationVo.validaPadraoEmail(emailAddress);

        this.emailAddress = emailAddress;
    }

}
