package com.security.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Customer implements Serializable {

	private static final long serialVersionUID = 5140900014886997914L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;

	@NotEmpty(message = "Nazwa użytkownika nie może pozostać pusta!")
	private String username;

	@NotEmpty(message = "Uzupełnij hasło!")
	@Size(min = 6, max = 16, message = "Hasło musi zawierać od 6 do 16 znaków!")
	private String password;

	private boolean enabled;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
