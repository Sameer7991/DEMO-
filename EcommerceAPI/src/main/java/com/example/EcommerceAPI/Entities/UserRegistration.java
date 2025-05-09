
package com.example.EcommerceAPI.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class UserRegistration {
	@Id
	long id;
	String name;
	String email;
	String password;
	public UserRegistration(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public UserRegistration() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPassword(String string) {
		this.password = string;
	}
	@Override
	public String toString() {
		return "UserRepo [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	

}
