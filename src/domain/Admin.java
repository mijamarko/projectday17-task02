package domain;

import enums.Roles;

public class Admin extends User{

	public Admin(String name, String surname, String username, String password, Roles role) {
		super(name, surname, username, password, role);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Admin [getRole()=" + getRole() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}


}
