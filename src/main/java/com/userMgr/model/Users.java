package com.userMgr.model;

public class Users {
	private String userName;
	private String password;
	private String email;
	
	
	public Users() {
		this.setUserName("Unknown");
		this.setEmail(null);
	}
	
	public Users(String name, String password, String email) {
		this.setUserName(name);
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
    public String toString() {
        return userName + ", " + password + ", " + email;
    }
	
	
}
