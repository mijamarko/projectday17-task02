package domain;

import java.util.Scanner;

import enums.Roles;
import exceptions.EmptyFieldException;
import exceptions.InvalidPasswordException;
import exceptions.NonExistingRoleException;
import exceptions.NonMatchingPasswordsException;
import exceptions.NonUniqueUsernameException;
import service.Validator;

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
	
	private void closeOrBack() {
		int selection = -1;
		System.out.print("Press 0 to go back to main many or any other key to exit.");
		try (Scanner sc = new Scanner(System.in)){
			selection = sc.nextInt();
			if(selection == 0) this.start();
			else System.exit(0);
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
		System.out.println("Creating a new user...");
		String selection = "", name = "", surname = "", username = "", password = "";
		Roles role = null;
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Enter the desired username: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.isUsernameUnique(selection, this.getUsers().users)) {
							username = selection;
							selection = null;
						}
					}
				} catch (EmptyFieldException | NonUniqueUsernameException e) {
					System.out.println(e.getMessage());
				}				
			} while(!selection.equals(null));
			System.out.println();
			System.out.print("Enter the user's name: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						name = selection;
						selection = null;
					}
				} catch (EmptyFieldException e) {
					System.out.println(e.getMessage());
				}				
			} while(!selection.equals(null));
			System.out.println();
			System.out.print("Enter the user's surname: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						surname = selection;
						selection = null;
					}
				} catch (EmptyFieldException e) {
					System.out.println(e.getMessage());
				}				
			} while(!selection.equals(null));
			System.out.println();
			System.out.print("Enter the user's password: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.isPasswordValid(selection)) {
							password = selection;
							selection = null;
						}
					}
				} catch (InvalidPasswordException | EmptyFieldException e) {
					System.out.println(e.getMessage());
				}
			} while(!selection.equals(null));
			System.out.println();
			System.out.print("Repeat the user's password: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.doPasswordsMatch(password, selection)) {
							selection = null;
						}
					}
				} catch (NonMatchingPasswordsException | EmptyFieldException e) {
					System.out.println(e.getMessage());
				}
			} while(!selection.equals(null));
			System.out.println();
			System.out.print("What is the user's role: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						role = Validator.roleExists(selection);
						selection = null;
					}
				} catch (EmptyFieldException | NonExistingRoleException e) {
					System.out.println(e.getMessage());
				}
			} while(!selection.equals(null));
		}
		if(role == Roles.ADMIN) {
			this.getUsers().users.add(new Admin(name, surname, username, password, role));
		} else
			this.getUsers().users.add(new Editor(name, surname, username, password, role));
		System.out.println("User successfully created!");
		closeOrBack();
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