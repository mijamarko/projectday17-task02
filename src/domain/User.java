package domain;

import java.util.Objects;

import enums.Roles;

public class User {
	
	private String name;
	private String surname;
	private String username;
	private String password;
	private Roles role;
	
	
	public User(String name, String surname, String username, String password, Roles role) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Roles getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, password, role, surname, username);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User) || obj == null) return false;
		User other = (User) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
