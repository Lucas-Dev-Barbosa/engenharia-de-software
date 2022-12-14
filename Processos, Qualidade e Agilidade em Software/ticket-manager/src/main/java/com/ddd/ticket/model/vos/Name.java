package com.ddd.ticket.model.vos;

public class Name {
	
	private String firstName;
	private String lastName;
	
	public Name(String firstName, String lastName) throws Exception {
		if ((firstName == null || firstName.isBlank()) || (lastName == null || lastName.isBlank()))
			throw new Exception("Digite o nome do customer");
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
}
