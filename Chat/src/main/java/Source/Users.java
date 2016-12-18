package Source;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String city;

	private String name;

	private String surname;

	public Users() {
	}

	public Users(String email, String city, String name, String surname) {
		this.email = email;
		this.city = city;
		this.name = name;
		this.surname = surname;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}