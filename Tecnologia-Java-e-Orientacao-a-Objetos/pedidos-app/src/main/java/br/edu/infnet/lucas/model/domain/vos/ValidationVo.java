package br.edu.infnet.lucas.model.domain.vos;

import br.edu.infnet.lucas.model.domain.exception.CpfInvalidoException;
import br.edu.infnet.lucas.model.domain.exception.EmailInvalidoException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationVo {

    private static final String EMAIL_REGEX = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    private static final String CPF_REGEX = "\\d{3}.\\d{3}.\\d{3}\\-\\d{2}";

    public static void validaPadraoEmail(String email) throws EmailInvalidoException {
        if(isPadraoInvalido(email, EMAIL_REGEX))
            throw new EmailInvalidoException("E-mail invalido");
    }

    public static void validaPadraoCpf(String cpf) throws CpfInvalidoException {
        if(isPadraoInvalido(cpf, CPF_REGEX))
            throw new CpfInvalidoException("Cpf invalido");
    }

    private static boolean isPadraoInvalido(String textToValidate, String stringRegex) {
        return !getMatcher(textToValidate, stringRegex).matches();
    }

    private static Matcher getMatcher(String textToValidate, String stringRegex) {
        Pattern pattern = Pattern.compile(stringRegex, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(textToValidate);
    }

}
