package login;

import java.io.Serializable;

public class LoginResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String email;

	private String city;

	private String name;

	private String password;

	private String surname;
	
	private int admin;

	public LoginResult() {
	}

	public LoginResult(String email, String city, String name, String password, String surname, int admin) {
		super();
		this.email = email;
		this.city = city;
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	

}
