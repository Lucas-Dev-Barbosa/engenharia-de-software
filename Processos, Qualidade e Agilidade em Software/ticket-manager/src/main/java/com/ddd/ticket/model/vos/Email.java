package com.ddd.ticket.model.vos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	private String emailAddress;

	public Email(String email) throws Exception {
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);

		if (!matcher.matches())
			throw new Exception("E-mail invalido");

		this.emailAddress = email;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

}
