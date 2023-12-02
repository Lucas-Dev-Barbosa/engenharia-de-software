package br.edu.infnet.lucas.model.domain.vos;

import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;

public class Email {

    private final String emailAddress;

    public Email(String email) throws EmailInvalidoException {
        ValidationVo.validaPadraoEmail(email);

        this.emailAddress = email;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
