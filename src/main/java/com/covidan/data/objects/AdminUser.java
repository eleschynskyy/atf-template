package com.covidan.data.objects;

public class AdminUser {
	
	private String username;
	private String password;
	
	public AdminUser setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public AdminUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "AdminUser [username=" + username + ", password=" + password
				+ "]";
	}
	
}
