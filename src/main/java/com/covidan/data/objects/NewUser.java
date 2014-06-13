package com.covidan.data.objects;

public class NewUser {
	
	private String username;
	private String password;
	private String passwordConfirmation;
	private String firstName;
	private String lastName;
	private String email;
	
	public NewUser setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public NewUser setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public NewUser setPasswordConfirmation(String password) {
		this.passwordConfirmation = password;
		return this;
	}
	
	public NewUser setfirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public NewUser setlastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public NewUser setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "NewUser [username=" + username + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}

}