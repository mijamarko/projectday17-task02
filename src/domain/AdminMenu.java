package domain;

import java.util.Scanner;

import enums.Roles;
import exceptions.EmptyFieldException;
import exceptions.InvalidPasswordException;
import exceptions.NonExistingRoleException;
import exceptions.NonMatchingPasswordsException;
import exceptions.NonUniqueUsernameException;
import service.UserMenu;
import service.Validator;

public class AdminMenu implements UserMenu {
	
	private String username;
	
	public AdminMenu(String username) {
		super();
		this.username = username;
	}

	@Override
	public void start() {
		this.showMainMenu();
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

	private User createUser() {
		System.out.println("Creating a new user...");
		String selection = "", name = "", surname = "", username = "", password = "";
		Roles role = null;
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Enter the desired username: ");
			do {
				selection = sc.nextLine();
				try {
					if(Validator.notNullOrEmpty(selection)) {
						if(Validator.isUsernameUnique(selection)) {
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
		UserList.getInstance().addUser(new User(name, surname, username, password, role));
	}

	@Override
	public void showMainMenu() {
		System.out.println("Hello, "+ this.username);
		System.out.println("Welcome to the Administration menu. Enter the corresponding number to access a feature.");
		System.out.println("1. Create a new user");
		System.out.println("2. Show all users");
		System.out.println("3. Show specific user");
		System.out.println("4. Edit a user");
		System.out.println("5. Delete a user");
		System.out.println("0. Exit");
	}

}
