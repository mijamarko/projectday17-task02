package domain;

import java.util.Scanner;

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
	
	public void start() {
		this.showMenu();
		int selection = -1;
		try (Scanner sc = new Scanner(System.in)){
			selection = sc.nextInt();
			while(selection < 0 || selection > 5) {
				System.out.println("Please select a valid option.");
				this.start();
			}
			switch(selection) {
			case 1:
				this.createUser();
				break;
			case 2:
				this.showAllUsers();
				break;
			case 3:
				this.showUser();
				break;
			case 4:
				this.editUser();
				break;
			case 5:
				this.deleteUser();
				break;
			default:
				System.exit(0);
			}
		}
	}

	private void deleteUser() {
		// TODO Auto-generated method stub

	}

	private void editUser() {
		// TODO Auto-generated method stub
		
	}

	private void showUser() {
		// TODO Auto-generated method stub
		
	}

	private void showAllUsers() {
		// TODO Auto-generated method stub
		
	}

	private void createUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMenu() {
		System.out.println("Welcome to the Administration menu. Enter the corresponding number to access a feature.");
		System.out.println("1. Create a new user");
		System.out.println("2. Show all users");
		System.out.println("3. Show specific user");
		System.out.println("4. Edit a user");
		System.out.println("5. Delete a user");
		System.out.println("0. Exit");
	}

}