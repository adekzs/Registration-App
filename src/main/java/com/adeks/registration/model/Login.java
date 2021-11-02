package com.adeks.registration.model;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class Login {
	
	private String name;
	private String password;
	
	public Login() {
		
	}
	
	public Login(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [name=" + name + ", password=" + password + "]";
	}
	
	
	
	

}
