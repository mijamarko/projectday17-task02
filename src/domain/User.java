package domain;

import java.util.Objects;

import enums.Roles;

public abstract class User {
	
	private final String name;
	private final String surname;
	private final String username;
	private final String password;
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
